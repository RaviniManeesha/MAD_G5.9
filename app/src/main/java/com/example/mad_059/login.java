package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class login extends AppCompatActivity {

     TextView  txtRegNo,txtPwd;
     Button btnLogin;
     DBHelper DB;
     String RegNo,Pwd,Reg,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtRegNo = findViewById(R.id.Regno);
        txtPwd = findViewById(R.id.pwd);
        btnLogin = findViewById(R.id.btnlogin);

        DB = new DBHelper(this);

        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                RegNo = cursor.getString(1);
                Pwd = cursor.getString(2);
            }
        }

        txtRegNo.setText(RegNo);
        txtPwd.setText(Pwd);

        Reg = txtRegNo.getText().toString();
        pwd = txtPwd.getText().toString();

    }

    public void openProfile(View view){

        if(TextUtils.isEmpty( txtRegNo.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter the Registration Number",Toast.LENGTH_SHORT).show();
        else if(TextUtils.isEmpty(txtPwd.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter the Password",Toast.LENGTH_SHORT).show();
        else{
            if(RegNo == Reg && Pwd == pwd) {


            }else{
                Intent intent = new Intent(this, profile.class);
                startActivity(intent);
            }
        }

    }

    public void resetPwd(View view){
        Intent intent1 = new Intent(login.this,resetpwd1.class);
        startActivity(intent1);

    }

    }
