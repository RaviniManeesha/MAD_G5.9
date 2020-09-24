package com.example.mad_059;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_059.Database.DBHelper;

public class register1 extends AppCompatActivity {

    TextView txtRegNo,txtPwd;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        btnNext = findViewById(R.id.btn1);
        txtRegNo = findViewById(R.id.ETRegNo);
        txtPwd = findViewById(R.id.ETpwd);

    }

    public void openNext(View view){
        Intent intent2 = new Intent(this,register2.class);

        if(TextUtils.isEmpty(txtRegNo.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Please enter the Registration Number", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(txtPwd.getText().toString())){
            Toast.makeText(getApplicationContext(), "Please enter the Password", Toast.LENGTH_SHORT).show();
        }else {

            intent2.putExtra("RegNo", txtRegNo.getText().toString());
            intent2.putExtra("Pwd", txtPwd.getText().toString());
            startActivity(intent2);
        }
    }

}







