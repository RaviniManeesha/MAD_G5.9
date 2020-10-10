package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class fees_main extends AppCompatActivity {
    String No;
    TextView txtRegNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_main);

        txtRegNo = findViewById(R.id.id);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);
    }

    public void openPro(View view){
        Intent intent1 = new Intent(this,proratafee2.class);
        startActivity(intent1);
    }

    public void openRepeat(View view){
        Intent intent1 = new Intent(this,proratafee1.class);
        startActivity(intent1);
    }

    public void openBack(View view){
        Intent intent1 = new Intent(this,profile.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }
}