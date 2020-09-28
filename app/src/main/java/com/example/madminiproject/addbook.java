package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addbook extends AppCompatActivity {


    EditText title_input, dateB_input, dateE_input;
    Button add_button;
    MyDatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

        title_input = findViewById(R.id.title_input);
        dateB_input = findViewById(R.id.dateB_input);
        dateE_input = findViewById(R.id.dateE_input);
        add_button = findViewById(R.id.add_button);

        DB = new MyDatabaseHelper(this);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = title_input.getText().toString();
                String dateB = dateB_input.getText().toString();
                String dateE = dateE_input.getText().toString();

                Boolean checkinsertdata = DB.InsertData(title, dateB, dateE);
                if (checkinsertdata == true)
                    Toast.makeText(addbook.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(addbook.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}