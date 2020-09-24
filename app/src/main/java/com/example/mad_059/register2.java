package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mad_059.Database.DBHelper;


public class register2 extends AppCompatActivity {

    TextView txtName,txtPhone,txtEmail,txtDate;
    TextView txtRegNo,txtPwd;
    Button btnRegister;
    DBHelper DB;
    String No,Pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);


        txtName = findViewById(R.id.stname);
        txtPhone= findViewById(R.id.phoneNo);
        txtEmail= findViewById(R.id.email);
        txtDate= findViewById(R.id.date);

        txtRegNo = findViewById(R.id.ETRegNo);
        txtPwd= findViewById(R.id.ETpwd);

        Intent intent = getIntent();

        No = intent.getStringExtra("RegNo");
        Pwd = intent.getStringExtra("Pwd");

        txtRegNo.setText(No);
        txtPwd.setText(Pwd);

        DB = new DBHelper(this);
        btnRegister= findViewById(R.id.btn2);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(txtName.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Student Name", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txtPhone.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Phone Number", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txtEmail.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please enter the Email", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txtDate.getText().toString())){
                Toast.makeText(getApplicationContext(), "Please enter the Registered Date", Toast.LENGTH_SHORT).show();
                }else{

                    String Name = txtName.getText().toString();
                    String Phone = txtPhone.getText().toString();
                    String Email = txtEmail.getText().toString();
                    String Date = txtDate.getText().toString();
                    String RegNo = txtRegNo.getText().toString();
                    String PWD = txtPwd.getText().toString();

                    Boolean checkinsertdata = DB.insertData(RegNo,PWD,Name,Phone,Email,Date);
                    if (checkinsertdata == true) {
                        Toast.makeText(register2.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(register2.this, "No Registered Successfully", Toast.LENGTH_SHORT).show();
                    }

                    openRegister();
                }

            }        });
    }

    public void openRegister(){
        Intent intent2 = new Intent(this,profile.class);
        startActivity(intent2);
    }


}