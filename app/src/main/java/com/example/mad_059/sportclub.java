package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sportclub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sportclub);
    }

    //go back
    public  void  goBack(View view){
        Intent intent1 = new Intent(sportclub.this,sports.class);
        startActivity(intent1);

    }
}