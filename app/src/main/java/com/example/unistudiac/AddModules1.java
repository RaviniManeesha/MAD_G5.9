package com.example.unistudiac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AddModules1 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modules1);

        Spinner module = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> moduleAdapter = new ArrayAdapter<String>(AddModules1.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.dropdown));
        moduleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        module.setAdapter(moduleAdapter);

        Spinner faculty = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> facultyAdapter = new ArrayAdapter<String>(AddModules1.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.faculty));
        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        faculty.setAdapter(facultyAdapter);

        Spinner year = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(AddModules1.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.year));
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(yearAdapter);

        Spinner sem = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> semAdapter = new ArrayAdapter<String>(AddModules1.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.semester));
        semAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sem.setAdapter(semAdapter);

        Spinner co = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> coAdapter = new ArrayAdapter<String>(AddModules1.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.course));
        coAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        co.setAdapter(coAdapter);

    }


}