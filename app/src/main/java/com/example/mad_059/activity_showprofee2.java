package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_showprofee2 extends AppCompatActivity {
    private TextView  proResult1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprofee2);

        proResult1 = findViewById(R.id.proResult);

        Bundle extras = getIntent().getExtras();

        double result1 = extras.getDouble("proValue");

        proResult1.setText(""+result1);


        System.out.println(result1);


    }
}