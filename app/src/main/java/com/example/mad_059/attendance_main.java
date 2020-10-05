package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mad_059.Database.DBHelper;

public class attendance_main extends AppCompatActivity {

    DBHelper DB;
    String No;
    TextView txtRegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_main);

        txtRegNo = findViewById(R.id.no);
        DB = new DBHelper(attendance_main.this);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);
    }

    public  void  addSubject(View view){
        Intent intent2 = new Intent(attendance_main.this,Monday.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public  void  checkDays(View view){
        Intent intent2 = new Intent(attendance_main.this,Calculate.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public  void  goBack5(View view){
        Intent intent2 = new Intent(attendance_main.this,profile.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

}