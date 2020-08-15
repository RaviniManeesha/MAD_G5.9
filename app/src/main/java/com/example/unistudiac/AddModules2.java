package com.example.unistudiac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddModules2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modules2);

        /*Spinner module = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> moduleAdapter = new ArrayAdapter<String>(AddModules2.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.dropdown));
        moduleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        module.setAdapter(moduleAdapter);*/
    }
}