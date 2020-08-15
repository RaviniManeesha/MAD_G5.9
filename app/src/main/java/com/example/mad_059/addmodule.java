package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class addmodule extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmodule);

        textView1 = (TextView) findViewById(R.id.textView24);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(addmodule.this,viewsubmissions.class);
                startActivity(intent1);


            }
        });

        textView2 = (TextView) findViewById(R.id.textView30);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(addmodule.this,viewsubmissions.class);
                startActivity(intent1);


            }
        });
    }
}