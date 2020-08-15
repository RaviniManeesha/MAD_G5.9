package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView2 = (TextView) findViewById(R.id.textView5);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(profile.this,viewprofile.class);
                startActivity(intent2);

            }
        });

        Button button5 = (Button) findViewById(R.id.button10);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogout();
            }
        });

        Button button6 = (Button) findViewById(R.id.button3);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubmissions();
            }
        });

        Button button7 = (Button) findViewById(R.id.button9);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInformation();
            }
        });
    }

    public void openLogout(){

        Intent intent8 = new Intent(this,login.class);
        startActivity(intent8);


    }
    public void openSubmissions(){

        Intent intent6 = new Intent(this,viewsubmissions.class);
        startActivity(intent6);


    }

    public void openInformation(){

        Intent intent7 = new Intent(this,information.class);
        startActivity(intent7);


    }
}