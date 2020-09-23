package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

     TextView txtEmail,txtPwd,txt2;
     Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtEmail = findViewById(R.id.Email);
        txtPwd = findViewById(R.id.pwd);
        btnlogin = findViewById(R.id.btnlogin);

        txt2 = findViewById(R.id.TextView2);
        txt2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1 = new Intent(login.this,resetpwd1.class);
            startActivity(intent1);

        }
    });

    }

    public void openProfile(View view){

        if(TextUtils.isEmpty(txtEmail.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter the Registration Number",Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(txtPwd.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter the Password",Toast.LENGTH_SHORT).show();
        else{
            Intent intent = new Intent(this, profile.class);
            startActivity(intent);
        }

    }

    }
