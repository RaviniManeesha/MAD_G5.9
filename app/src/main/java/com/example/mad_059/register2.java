package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_059.Database.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register2 extends AppCompatActivity {

    EditText txtStName,txtPhone,txtEmail,txtDate,txtRegNo,txtPwd,txtRePwd;
    Button btnregister;
    String regNo,pwd,repwd;
    DatabaseReference dbRef;
    Student std;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        txtStName = findViewById(R.id.stname);
        txtPhone = findViewById(R.id.phoneNo);
        txtEmail = findViewById(R.id.email);
        txtDate = findViewById(R.id.date);
        txtRegNo = findViewById(R.id.ETRegNo);
        txtPwd = findViewById(R.id.ETpwd);
        txtRePwd = findViewById(R.id.ETrepwd);

        Intent intent = getIntent();

        regNo = intent.getStringExtra("regno");
        pwd = intent.getStringExtra("pwd");
        repwd = intent.getStringExtra("repwd");

        txtRegNo.setText(regNo);
        txtPwd.setText(pwd);
        txtRePwd.setText(repwd);

        btnregister = findViewById(R.id.btn2);
        std = new Student();

        //insert 2 register forms data
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Student");
                try {

                    if(TextUtils.isEmpty(txtStName.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter the Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtPhone.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter the Phone Number",Toast.LENGTH_SHORT).show();
                    else  if(TextUtils.isEmpty(txtEmail.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please reenter the SLIIT Email",Toast.LENGTH_SHORT).show();
                    else  if(TextUtils.isEmpty(txtDate.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please reenter the Admission Date",Toast.LENGTH_SHORT).show();
                    else{

                        std.setStName(txtStName.getText().toString().trim());
                        std.setPhone(Integer.parseInt(txtPhone.getText().toString().trim()));
                        std.setEmail(txtEmail.getText().toString().trim());
                        std.setDate(txtDate.getText().toString().trim());
                        std.setRegNo(txtRegNo.getText().toString().trim());
                        std.setPwd(txtPwd.getText().toString().trim());
                        std.setRepwd(txtRePwd.getText().toString().trim());

                        dbRef.child("Std1").setValue(std);
                        Toast.makeText(getApplicationContext(),"Registered Successfully!",Toast.LENGTH_SHORT).show();
                        clearControls();

openRegister();
                    }
                }catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void openRegister(){
        Intent intent2 = new Intent(this,profile.class);

        startActivity(intent2);
    }

    private void clearControls(){

        txtStName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtDate.setText("");
        txtRegNo.setText("");
        txtPwd.setText("");
        txtRePwd.setText("");
    }

}