package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class all extends AppCompatActivity {
    TextView textView1,textView2,textView3;
    TextView Module;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        Module = findViewById(R.id.m1);


        textView2 = (TextView) findViewById(R.id.textView57);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(all.this,addsubmissison.class);
                startActivity(intent1);


            }
        });


    }

    public  void openModule(View view){
        Intent intent1 = new Intent(all.this,module.class);
        startActivity(intent1);
    }

    public  void goSub(View view){
        Intent intent2 = new Intent(all.this,viewsubmissions.class);
        startActivity(intent2);
    }
}