package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class gpa extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9;
    Button btn1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        e1 = findViewById(R.id.credit);
        e2 = findViewById(R.id.m1g);
        e3 = findViewById(R.id.m1c);
        e4 = findViewById(R.id.m2g);
        e5 = findViewById(R.id.m2c);
        e6 = findViewById(R.id.m3g);
        e7 = findViewById(R.id.m3c);
        e8 = findViewById(R.id.m4g);
        e9 = findViewById(R.id.m4c);
        t1 = findViewById(R.id.txtCGPA);
        btn1 = findViewById(R.id.cal);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calGpa();
            }
        });




    }
    public void calGpa(){
        String m1g, m2g, m3g, mg4;
        int cr1,cr2,cr3,cr4;

        int totCr;
        double gpa1, gpa2, gpa3, gpa4;

        totCr = Integer.parseInt(e1.getText().toString());
        m1g = e2.getText().toString().trim();
        m2g = e4.getText().toString().trim();
        m3g = e6.getText().toString().trim();
        mg4 = e8.getText().toString().trim();

        cr1 = Integer.parseInt(e3.getText().toString());
        cr2 = Integer.parseInt(e5.getText().toString());
        cr3 = Integer.parseInt(e7.getText().toString());
        cr4 = Integer.parseInt(e9.getText().toString());


        float a,b,c,d;
        a = checkGPA(m1g);
        String l= String.valueOf(a);
        b =checkGPA(m2g);
        c=checkGPA(m3g);
        d = checkGPA(mg4);

        float totGPA = (a * cr1/totCr)+(b * cr2/totCr)+(c * cr3/totCr)+( d * cr4/totCr);
        t1.setText(String.valueOf(totGPA));

    }
    private  float checkGPA(String m){
        float res;
        if(m.equalsIgnoreCase("A+")){
            return res = (float) 4.0;
        }else if(m.equalsIgnoreCase("A")){
            return res = (float) 4.0;
        }else if(m.equalsIgnoreCase("A-")){
            return res = (float) 3.7;
        }else if(m.equalsIgnoreCase("B+")){
            return res = (float) 3.3;
        }else if(m.equalsIgnoreCase("B")){
            return res = (float) 3.0;
        }else if(m.equalsIgnoreCase("B-")){
            return res = (float) 2.7;
        }else if(m.equalsIgnoreCase("C+")){
            return res = (float) 2.3;
        }else if(m.equalsIgnoreCase("C")){
            return res = (float) 2.0;
        }else{
            return res = (float) 0;
        }
    }
}