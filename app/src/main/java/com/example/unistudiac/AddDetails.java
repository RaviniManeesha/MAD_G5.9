package com.example.unistudiac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDetails extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        e1 = findViewById(R.id.modN);
        e2 = findViewById(R.id.modcod);
        e3 = findViewById(R.id.nocr);
        e4 = findViewById(R.id.cam);
        e5 = findViewById(R.id.fnm);
        e6 = findViewById(R.id.ref);

        btnAdd = findViewById(R.id.adDet);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddDetails.this);
                myDB.addDetails(e1.getText().toString().trim(), e2.getText().toString().trim(),e3.getText().toString().trim(),e4.getText().toString().trim(),e5.getText().toString().trim(),e6.getText().toString().trim());
            }
        });

    }
}