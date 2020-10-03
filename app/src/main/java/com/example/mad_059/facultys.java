package com.example.mad_059;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class facultys extends AppCompatActivity {
    String No;
    TextView txtRegNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultys);

        txtRegNo = findViewById(R.id.id);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);

    }
    //go back
    public  void  goBack(View view){
        Intent intent1 = new Intent(facultys.this, sports.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);

    }
}