package com.example.attendancecriteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cafetaria extends AppCompatActivity {
Button button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafetaria);

        OnclickButtonLister();
    }

    public void OnclickButtonLister(){
        button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),UniInfo.class);
                        startActivity(intent);
                    }
                }
        );
    }
}