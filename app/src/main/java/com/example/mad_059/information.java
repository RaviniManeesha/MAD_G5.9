package com.example.mad_059;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class information extends AppCompatActivity {
    String No;
    TextView txtRegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        txtRegNo = findViewById(R.id.id);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);
    }

    //go Back method (go back to profile)
    public void goBack(View view){
        Intent intent1 = new Intent(information.this, profile.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);

    }
    //open Education Information Details
    public void openEduInfo(View view){
        Intent intent2 = new Intent(this, eduinfo.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);


    }
}