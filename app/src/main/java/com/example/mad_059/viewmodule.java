package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class viewmodule extends AppCompatActivity {
    private TextView textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodule);

        textView1 = (TextView) findViewById(R.id.textView32);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewmodule.this,viewsubmissions.class);
                startActivity(intent1);


            }
        });

        textView2 = (TextView) findViewById(R.id.textView38);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewmodule.this,addsubmissison.class);
                startActivity(intent1);


            }
        });

        textView3 = (TextView) findViewById(R.id.textView95);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewmodule.this,submission.class);
                startActivity(intent1);


            }
        });
    }
}