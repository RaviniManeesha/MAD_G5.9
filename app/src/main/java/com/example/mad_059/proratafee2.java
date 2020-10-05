package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class proratafee2 extends AppCompatActivity {

    private EditText proInput, modInput2;
    private TextView proResult;
    private Button btnsub4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proratafee2);

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
                f= d * e;

                Intent intent = new Intent(proratafee2.this,activity_showprofee2.class);
                intent.putExtra("proValue",f);
                startActivity(intent);


            }

        });


    }
    public  double multiplyNumbers2(double d,double e){
        return d * e;
    }
}