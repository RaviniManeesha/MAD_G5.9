package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class today extends AppCompatActivity {
    private TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        textView2 = (TextView) findViewById(R.id.textView45);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(today.this,addsubmissison.class);
                startActivity(intent1);


            }
        });

        textView2 = (TextView) findViewById(R.id.textView82);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(today.this,submission.class);
                startActivity(intent1);


            }
        });
    }
    public  void  goSub(View view){
        Intent intent1 = new Intent(today.this,viewsubmissions.class);
        startActivity(intent1);
    }

}