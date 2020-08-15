package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viewprofile extends AppCompatActivity {

    private Button button3;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        button3 =(Button) findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEdit();
            }
        });

        textView2 = (TextView) findViewById(R.id.textView19);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewprofile.this,profile.class);
                startActivity(intent1);


            }
        });
    }

    public void openEdit(){

        Intent intent3 = new Intent(this,editprofile.class);
        startActivity(intent3);
    }
}