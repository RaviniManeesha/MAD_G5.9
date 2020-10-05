package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class proratafee1 extends AppCompatActivity {

    private EditText modInput, repInput;
    private TextView reResult;
    private Button btnsub3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proratafee1);

        modInput = findViewById(R.id.modInput);
        repInput = findViewById(R.id.repInput);
        reResult = findViewById(R.id.reResult);
        btnsub3 = findViewById(R.id.btnsub);

        btnsub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a,b,c;

                a= Double.parseDouble(modInput.getText().toString());
                b= Double.parseDouble(repInput.getText().toString());
                c= a * b;

                Intent intent = new Intent(proratafee1.this,showprofee1.class);
                intent.putExtra("repValue",c);
                startActivity(intent);


            }

        });


    }

    public  double multiplyNumbers(double a,double b){
        return a * b;
    }
}