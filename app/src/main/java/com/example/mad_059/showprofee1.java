package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class showprofee1 extends AppCompatActivity {

    private TextView reResult1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showprofee1);

        reResult1 = findViewById(R.id.reResult);

        Bundle extras = getIntent().getExtras();
        double result = extras.getDouble("repValue");

        reResult1.setText(""+result);

        System.out.println(result);


    }
}