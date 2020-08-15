package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class editprofile extends AppCompatActivity {

    private Button button4;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        button4 =(Button) findViewById(R.id.button11);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDone();
            }
        });

        textView4 = (TextView) findViewById(R.id.textView22);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(editprofile.this,viewprofile.class);
                startActivity(intent1);


            }
        });
    }

    public void openDone(){

        Intent intent4 = new Intent(this,viewprofile.class);
        startActivity(intent4);
    }
}