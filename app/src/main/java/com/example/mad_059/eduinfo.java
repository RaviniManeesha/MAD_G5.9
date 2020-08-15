package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class eduinfo extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eduinfo);

        textView1 = (TextView) findViewById(R.id.textView60);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(eduinfo.this,information.class);
                startActivity(intent2);

            }
        });

        textView2 = (TextView) findViewById(R.id.textView62);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(eduinfo.this,sports.class);
                startActivity(intent2);

            }
        });

        textView2 = (TextView) findViewById(R.id.textView63);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(eduinfo.this,fees.class);
                startActivity(intent2);

            }
        });

        textView2 = (TextView) findViewById(R.id.textView64);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(eduinfo.this,courses.class);
                startActivity(intent2);

            }
        });
    }
}