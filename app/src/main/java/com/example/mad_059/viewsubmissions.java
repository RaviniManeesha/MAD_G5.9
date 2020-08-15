package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viewsubmissions extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewsubmissions);

        textView2 = (TextView) findViewById(R.id.textView77);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewsubmissions.this,profile.class);
                startActivity(intent1);


            }
        });

        textView2 = (TextView) findViewById(R.id.textView21);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewsubmissions.this,today.class);
                startActivity(intent1);


            }
        });

        textView3 = (TextView) findViewById(R.id.textView23);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewsubmissions.this,scheduled.class);
                startActivity(intent1);


            }
        });

        textView4 = (TextView) findViewById(R.id.textView25);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewsubmissions.this,all.class);
                startActivity(intent1);


            }
        });

        textView5= (TextView) findViewById(R.id.textView26);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewsubmissions.this,addmodule.class);
                startActivity(intent1);


            }
        });

        button6 =(Button) findViewById(R.id.button12);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubmissions();
            }
        });
    }

    public void openSubmissions(){

        Intent intent7 = new Intent(this,viewmodule.class);
        startActivity(intent7);


    }
}