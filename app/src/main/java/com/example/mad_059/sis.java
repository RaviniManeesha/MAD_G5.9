package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sis);
    }

    //go back Sports and Clubs Details Activity
    public  void  goBack(View view)
    {
        Intent intent1 = new Intent(sis.this,sports.class);
        startActivity(intent1);

    }
}