package com.example.attendancecriteria;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Add_Form extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText Sub_input,Room_input,Teacher_input,dayT;
    TextView day,time;
    String wDAy;
    Button add_button,time_button;

    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__form);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.days,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(Add_Form.this);

        Room_input = findViewById(R.id.room_input);
        Teacher_input = findViewById(R.id.Teacher_input);
        Sub_input = findViewById(R.id.Sub_input);
        day = findViewById(R.id.day);
        time = findViewById(R.id.time);
        add_button = findViewById(R.id.add_button);
        time_button = findViewById(R.id.buttontime);

        Calendar calendar = Calendar.getInstance();
        final int minute = calendar.get(Calendar.MINUTE);

        final int hour = calendar.get(Calendar.HOUR_OF_DAY);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Add_Form.this);
                myDB.addSub(Sub_input.getText().toString().trim(),Room_input.getText().toString().trim(),Teacher_input.getText().toString().trim(),wDAy,time.getText().toString());

            }
        });

        time_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay + ":" + minute);
                    }
                },hour,minute,android.text.format.DateFormat.is24HourFormat(mContext));

                timePickerDialog.show();
            }
        });

    }



    public void onItemSelected(AdapterView<?> parent,View view,int position,long id){
        String text = parent.getItemAtPosition(position).toString();
        wDAy = text;
       // dayT.setText(text);
       // Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
}