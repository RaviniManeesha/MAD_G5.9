package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class adddetails extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6;
    Button btnAdd;
    TextView txtRegNo;
    String No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetails);

        e1 = findViewById(R.id.modN);
        e2 = findViewById(R.id.modcod);
        e3 = findViewById(R.id.nocr);
        e4 = findViewById(R.id.cam);
        e5 = findViewById(R.id.fnm);
        e6 = findViewById(R.id.ref);

        //get passing ID
        txtRegNo = findViewById(R.id.reg);
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);

        btnAdd = findViewById(R.id.adDet);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(adddetails.this);

                Boolean checkinsertdata =  myDB.addDetails4(e1.getText().toString().trim(), e2.getText().toString().trim(),e3.getText().toString().trim(),e4.getText().toString().trim(),e5.getText().toString().trim(),e6.getText().toString().trim(),No);
                if (checkinsertdata == true) {
                    Toast.makeText(adddetails.this, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
                    goDetails();

                }else
                    Toast.makeText(adddetails.this, "Failed", Toast.LENGTH_SHORT).show();



            }
        });

    }

    public  void  goDetails(){
        Intent intent2 = new Intent(adddetails.this,detailslist.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}