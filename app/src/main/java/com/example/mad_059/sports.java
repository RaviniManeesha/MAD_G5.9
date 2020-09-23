package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

    }

    //go back (Education Information Activity)
    public  void  goBack(View view){
        Intent intent1 = new Intent(sports.this,eduinfo.class);
        startActivity(intent1);
    }

    //open SIS
    public  void openSIS(View view){
        Intent intent2 = new Intent(sports.this,sis.class);
        startActivity(intent2);

    }

    //open Faculty Socities
    public void openFaculty(View view){
        Intent intent3 = new Intent(sports.this,facultys.class);
        startActivity(intent3);

    }

    //open Sport Club
    public  void openSports(View view){

        Intent intent4 = new Intent(sports.this,sportclub.class);
        startActivity(intent4);

    }

    //open Other Socities
    public void  openOthers(View view){

        Intent intent5 = new Intent(sports.this,othe_clubs.class);
        startActivity(intent5);

    }



}