package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class showResults3 extends AppCompatActivity {

        //test comment3
        private TextView  proResult1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_show_results3);

                proResult1 = findViewById(R.id.proResult);

                Bundle extras = getIntent().getExtras();

                double result1 = extras.getDouble("proValue");

                proResult1.setText(""+result1);


                System.out.println(result1);
        }
}