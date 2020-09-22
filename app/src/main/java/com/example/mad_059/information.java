package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    //go Back method (go back to profile)
    public void goBack(View view){
        Intent intent1 = new Intent(information.this,profile.class);
        startActivity(intent1);

    }
    //open Education Information Details
    public void openEduInfo(View view){

        Intent intent2 = new Intent(this,eduinfo.class);
        startActivity(intent2);


    }
}