package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fees_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_main);
    }

    public void openPro(View view){
        Intent intent1 = new Intent(this,proratafee2.class);
        startActivity(intent1);
    }

    public void openRepeat(View view){
        Intent intent1 = new Intent(this,proratafee1.class);
        startActivity(intent1);
    }
}