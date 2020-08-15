package com.example.attendancecriteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UniInfo extends AppCompatActivity {
Button button;
Button button3;
    Button button4;
    Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_info);


        OnclickButtonLister();
    }

    public void OnclickButtonLister() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), NameList.class);
                        startActivity(intent);
                    }
                }
        );

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Events.class);
                        startActivity(intent);
                    }
                }
        );

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), Cafetaria.class);
                        startActivity(intent);
                    }
                }
        );

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),Map.class);
                        startActivity(intent);
                    }
                }
        );
    }
}