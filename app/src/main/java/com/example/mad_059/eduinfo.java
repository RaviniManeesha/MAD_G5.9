package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class eduinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eduinfo);

    }
    //open Sports and Clubs Details
    public void openSports(View view){
        Intent intent1 = new Intent(eduinfo.this,sports.class);
        startActivity(intent1);

    }

    //open Fees Details
    public void openFees(View view){

        Intent intent2 = new Intent(eduinfo.this,fees.class);
        startActivity(intent2);
    }

    //open Details about Courses
    public void openCourses(View view){
        Intent intent3 = new Intent(eduinfo.this,courses.class);
        startActivity(intent3);

    }

    //go back (go back to information)
    public  void goBack(View view){
        Intent intent4 = new Intent(eduinfo.this,information.class);
        startActivity(intent4);
    }


}