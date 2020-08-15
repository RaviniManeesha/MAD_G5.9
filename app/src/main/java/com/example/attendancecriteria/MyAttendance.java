package com.example.attendancecriteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyAttendance extends AppCompatActivity {
    Button button9;
    ImageView imageView19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_attendance);
        OnclickButtonLister();
        }

    public void OnclickButtonLister(){

        imageView19 = (ImageView) findViewById(R.id.imageView19);
        imageView19.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Calender.class);
                        startActivity(intent);
                    }
                }
        );

    }
}