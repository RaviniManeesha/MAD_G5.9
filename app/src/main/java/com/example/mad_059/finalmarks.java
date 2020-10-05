package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalmarks extends AppCompatActivity {
    TextView ca, fn, total, grade;
    Button calc;
    String No;
    TextView txtRegNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalmarks);

        txtRegNo = findViewById(R.id.no);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);


        ca = findViewById(R.id.finalcam);

        fn = findViewById(R.id.finalcam2);

        total = findViewById(R.id.tot);

        grade = findViewById(R.id.grades);

        calc = findViewById(R.id.cal);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marksCal();
            }
        });

    }
    public void marksCal(){
        int cam, fnm, tot;
        String grd;

        cam = Integer.parseInt(ca.getText().toString());
        fnm = Integer.parseInt(fn.getText().toString());
        //tot = Integer.parseInt(total.getText().toString());

        tot = (cam + fnm) / 2;

        total.setText(String.valueOf(tot));


        if(tot >= 90){
            grade.setText("A+");
        }
        else if(tot >= 80 && tot <= 89){
            grade.setText("A");

        }
        else if(tot >= 75 && tot <= 79){
            grade.setText("A-");

        }
        else if(tot >= 70 && tot <= 74){
            grade.setText("B+");

        }
        else if(tot >= 65 && tot <= 69){
            grade.setText("B");

        }
        else if(tot >= 60 && tot <= 64){
            grade.setText("B-");

        }
        else if(tot >= 55 && tot <= 59){
            grade.setText("C+");

        }
        else if(tot >= 45 && tot <= 54){
            grade.setText("C");

        }
        else{
            grade.setText("F");
        }
    }

    public void goMain2(View view){
        Intent intent1 = new Intent(finalmarks.this,module_main.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }
}