package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLOutput;

public class proratafee3 extends AppCompatActivity {

    private EditText  proInput, modInput2;
    private TextView proResult;
    private Button btnsub4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proratafee3);

        proInput = findViewById(R.id.proInput);
        modInput2 = findViewById(R.id.modInput2);
        proResult = findViewById(R.id.proResult);
        btnsub4 = findViewById(R.id.btnsub4);

        btnsub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double d,e,f;

                d= Double.parseDouble(proInput.getText().toString());
                e= Double.parseDouble(modInput2.getText().toString());
                f=multiplyNumbers2(d, e);

                Intent intent = new Intent(proratafee3.this,showResults3.class);
                intent.putExtra("proValue",f);
                startActivity(intent);


            }

        });


    }

    public double multiplyNumbers2(double d, double e) {
        return d * e;
    }


}