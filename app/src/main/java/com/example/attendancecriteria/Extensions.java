package com.example.attendancecriteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Extensions extends AppCompatActivity {
Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extensions);

        OnclickButtonLister();
    }

    public void OnclickButtonLister(){
        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(
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