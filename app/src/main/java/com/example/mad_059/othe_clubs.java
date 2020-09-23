package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class othe_clubs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othe_clubs);
    }

    //go back
    public  void  goBack(View view){
        Intent intent1 = new Intent(othe_clubs.this,sports.class);
        startActivity(intent1);
    }
}