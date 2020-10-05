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

public class addbook extends AppCompatActivity {


    EditText title_input, dateB_input, dateE_input;
    Button add_button;
    DBHelper DB;
    String No;
    TextView txtRegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

        title_input = findViewById(R.id.title_input);
        dateB_input = findViewById(R.id.dateB_input);
        dateE_input = findViewById(R.id.dateE_input);
        add_button = findViewById(R.id.add_button);

        txtRegNo = findViewById(R.id.reg);
        DB = new DBHelper(addbook.this);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);


        DB = new DBHelper(this);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = title_input.getText().toString();
                String dateB = dateB_input.getText().toString();
                String dateE = dateE_input.getText().toString();

                Boolean checkinsertdata = DB.InsertData3(title, dateB, dateE,No);
                if (checkinsertdata == true) {
                    Toast.makeText(addbook.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    goBookList();
                }else
                    Toast.makeText(addbook.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public  void  goBookList(){
        Intent intent2 = new Intent(addbook.this,booklist.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}