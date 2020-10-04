package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class shoeResult2 extends AppCompatActivity {

    private TextView reResult1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoe_result2);

        reResult1 = findViewById(R.id.reResult);

        Bundle extras = getIntent().getExtras();
        double result = extras.getDouble("repValue");

        reResult1.setText(""+result);

        System.out.println(result);


    }
}