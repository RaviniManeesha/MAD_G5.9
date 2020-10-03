package com.example.mad_059;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class eduinfo extends AppCompatActivity {
    String No;
    TextView txtRegNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eduinfo);

        txtRegNo = findViewById(R.id.id);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);

    }
    //open Sports and Clubs Details
    public void openSports(View view){
        Intent intent1 = new Intent(eduinfo.this, sports.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);

    }

    //open Fees Details
    public void openFees(View view){

        Intent intent2 = new Intent(eduinfo.this, fees.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    //open Details about Courses
    public void openCourses(View view){
        Intent intent3 = new Intent(eduinfo.this, courses.class);
        intent3.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent3);

    }

    //go back (go back to information)
    public  void goBack(View view){
        Intent intent4 = new Intent(eduinfo.this, information.class);
        intent4.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent4);
    }


}