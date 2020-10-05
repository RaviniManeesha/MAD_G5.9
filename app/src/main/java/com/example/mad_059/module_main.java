package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class module_main extends AppCompatActivity {
    TextView txtRegNo;
    String No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_main);

        //get passing ID
        txtRegNo = findViewById(R.id.reg);
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);
    }

    public void openAddModuleHome(View view) {
        Intent intent = new Intent(this, modulelist.class);
        intent.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent);
    }

    public void goBack8(View view) {
        Intent intent = new Intent(this, profile.class);
        intent.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent);
    }

    public void openFinal(View view) {
        Intent intent = new Intent(this, finalmarks.class);
        intent.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent);
    }


    public void openGPA(View view) {
        Intent intent = new Intent(this, gpa.class);
        intent.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent);
    }

    public void openDetails(View view) {
        Intent intent = new Intent(this,detailslist.class);
        intent.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent);
    }
}