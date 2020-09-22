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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        txtRegNo = findViewById(R.id.ETRegNo);
        txtpwd = findViewById(R.id.ETpwd);
        txtrepwd = findViewById(R.id.ETrepwd);

        btnnext = findViewById(R.id.btn1);


    }

    public void openNext(View view){

        if(TextUtils.isEmpty(txtRegNo.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter the Registration Number",Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(txtpwd.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter the Password",Toast.LENGTH_SHORT).show();
        else  if(TextUtils.isEmpty(txtrepwd.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please reenter the Password",Toast.LENGTH_SHORT).show();
        else{
            Intent intent = new Intent(this,register2.class);
            intent .putExtra("regno",txtRegNo.getText().toString());
            intent .putExtra("pwd",txtpwd.getText().toString());
            intent .putExtra("repwd",txtrepwd.getText().toString());
            startActivity(intent);
        }


    }


}







