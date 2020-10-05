package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class campusInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_info);

    }
    public  void openExten(View view){
        Intent intent1 = new Intent(campusInfo.this,exten.class);
        startActivity(intent1);
    }

    public  void openEvent(View view){
        Intent intent1 = new Intent(campusInfo.this,Events.class);
        startActivity(intent1);
    }

    public  void openCaf(View view){
        Intent intent1 = new Intent(campusInfo.this,Caf.class);
        startActivity(intent1);
    }

    public  void openMap(View view){
        Intent intent1 = new Intent(campusInfo.this,Map.class);
        startActivity(intent1);
    }
}