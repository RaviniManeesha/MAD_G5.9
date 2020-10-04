package com.example.unistudiac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalMark extends AppCompatActivity {

    TextView ca, fn, total, grade;
    Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_mark);

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
    public int marksCal(){
        int tot;

        int cam = Integer.parseInt(ca.getText().toString());
        int fnm = Integer.parseInt(fn.getText().toString());

        tot = calculate(cam, fnm);

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
        return cam;
    }
    public int calculate(int cam, int fnm){
        return (cam + fnm) / 2;
    }
}