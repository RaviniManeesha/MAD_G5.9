package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class scheduled extends AppCompatActivity {
    private TextView textView1,textView2,textView3;

    public scheduled() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduled);



        textView2 = (TextView) findViewById(R.id.textView51);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(scheduled.this,addsubmissison.class);
                startActivity(intent1);


            }
        });

        textView2 = (TextView) findViewById(R.id.textView78);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(scheduled.this,submission.class);
                startActivity(intent1);


            }
        });
    }
    public  void  goSub(View view){
        Intent intent1 = new Intent(scheduled.this,viewsubmissions.class);
        startActivity(intent1);
    }
}