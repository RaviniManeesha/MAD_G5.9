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

public class AddModules extends AppCompatActivity {

    EditText title_input, input_no;
    Button button;
    TextView txtRegNo;
    String No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modules);

        title_input = findViewById(R.id.title_input);
        input_no = findViewById(R.id.input_no);
        button = findViewById(R.id.button);

        //get passing ID
        txtRegNo = findViewById(R.id.reg);
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(AddModules.this);

                Boolean checkinsertdata =  myDB.addModule4(title_input.getText().toString().trim(), input_no.getText().toString().trim(),
                        txtRegNo.getText().toString().trim());
                if (checkinsertdata == true) {
                    Toast.makeText(AddModules.this, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
                   goModuleList();
                }else
                    Toast.makeText(AddModules.this, "Failed", Toast.LENGTH_SHORT).show();


            }
        });
    }

    public  void  goModuleList(){
        Intent intent2 = new Intent(AddModules.this,modulelist.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}