package com.example.attendancecriteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button button13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        OnclickButtonLister();
    }

    public void OnclickButtonLister(){
        button13 = (Button)findViewById(R.id.button13);
        button13.setOnClickListener(
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