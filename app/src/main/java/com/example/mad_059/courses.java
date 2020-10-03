package com.example.mad_059;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class courses extends AppCompatActivity {
    String No;
    TextView txtRegNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        txtRegNo = findViewById(R.id.id);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);
    }

    public void goEduInfo(View view){
        Intent intent1 = new Intent(courses.this, eduinfo.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }
}