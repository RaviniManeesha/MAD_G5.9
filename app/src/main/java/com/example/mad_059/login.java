package com.example.mad_059;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
