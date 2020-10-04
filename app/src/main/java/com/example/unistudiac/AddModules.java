package com.example.unistudiac;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddModules extends AppCompatActivity {

    EditText title_input, input_no;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modules);

        title_input = findViewById(R.id.title_input);
        input_no = findViewById(R.id.input_no);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddModules.this);
                myDB.addModule(title_input.getText().toString().trim(), input_no.getText().toString().trim());

            }
        });
    }
}