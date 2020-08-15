package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class information extends AppCompatActivity {

    private TextView textView2;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        textView2 = (TextView) findViewById(R.id.textView58);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(information.this,profile.class);
                startActivity(intent2);

            }
        });

        button5 =(Button) findViewById(R.id.button23);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEduInfo();
            }
        });

    }

    public void openEduInfo(){

        Intent intent7 = new Intent(this,eduinfo.class);
        startActivity(intent7);


    }
}