package com.example.attendancecriteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Calender extends AppCompatActivity {

    Button button8;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        OnclickButtonLister();
    }

    public void OnclickButtonLister(){
        button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Menu.class);
                        startActivity(intent);
                    }
                }
        );

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Menu.class);
                        startActivity(intent);
                    }
                }
        );

    }

}
