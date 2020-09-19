package com.example.mad_059;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_059.Database.Student;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register1 extends AppCompatActivity {

    EditText txtRegNo,txtpwd,txtrepwd;
    Button btnnext;
    DatabaseReference dbRef;
    Student std;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        txtRegNo = findViewById(R.id.ETRegNo);
        txtpwd = findViewById(R.id.ETpwd);
        txtrepwd = findViewById(R.id.ETrepwd);

        btnnext = findViewById(R.id.btn1);
        std = new Student();

        //insert student register 1 data
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Student");

                if(TextUtils.isEmpty(txtRegNo.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Please enter the Registration Number",Toast.LENGTH_SHORT).show();
                else if(TextUtils.isEmpty(txtpwd.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Please enter the Password",Toast.LENGTH_SHORT).show();
                else  if(TextUtils.isEmpty(txtrepwd.getText().toString()))
                    Toast.makeText(getApplicationContext(),"Please reenter the Password",Toast.LENGTH_SHORT).show();
                else{
                    std.setRegNo(txtRegNo.getText().toString().trim());
                    std.setPwd(txtpwd.getText().toString().trim());
                    std.setRepwd(txtrepwd.getText().toString().trim());

                    dbRef.push().setValue(std);


                    clearControls();
                    openNext();
                }
            }
        });


    }

    private void clearControls(){

        txtRegNo.setText("");
        txtpwd.setText("");
        txtrepwd.setText("");
    }

    public void openNext(){

        Intent intent = new Intent(this,register2.class);
        startActivity(intent);
    }

}







