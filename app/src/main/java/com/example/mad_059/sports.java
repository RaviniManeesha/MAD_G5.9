package com.example.mad_059;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class sports extends AppCompatActivity {
    String No;
    TextView txtRegNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        txtRegNo = findViewById(R.id.id);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);
    }

    //go back (Education Information Activity)
    public  void  goBack(View view){
        Intent intent1 = new Intent(sports.this, eduinfo.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }

    //open SIS
    public  void openSIS(View view){
        Intent intent2 = new Intent(sports.this, sis.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);

    }

    //open Faculty Socities
    public void openFaculty(View view){
        Intent intent3 = new Intent(sports.this, facultys.class);
        intent3.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent3);

    }

    //open Sport Club
    public  void openSports(View view){

        Intent intent4 = new Intent(sports.this, sportclub.class);
        intent4.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent4);

    }

    //open Other Socities
    public void  openOthers(View view){

        Intent intent5 = new Intent(sports.this, othe_clubs.class);
        intent5.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent5);

    }



}