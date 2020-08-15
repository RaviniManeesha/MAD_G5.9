package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class editsubmission extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsubmission);

        text1 = (TextView) findViewById(R.id.textView34);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(editsubmission.this,submission.class);
                startActivity(intent1);


            }
        });

        text2 = (TextView) findViewById(R.id.textView35);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(editsubmission.this,submission.class);
                startActivity(intent1);


            }
        });
    }
}