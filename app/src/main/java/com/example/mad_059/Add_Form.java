package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class Add_Form extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText Sub_input,Room_input,Teacher_input,time;
    TextView day;
    String wDAy,Sub,Teacher,Room,time1;
    Button add_button;
    String No;
    TextView txtRegNo;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__form);

        txtRegNo = findViewById(R.id.reg);
        myDB = new DBHelper(Add_Form.this);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);


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


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DBHelper myDB = new DBHelper(Add_Form.this);

               Sub = Sub_input.getText().toString();
               Teacher = Teacher_input.getText().toString();
              Room  = Room_input.getText().toString();
               time1 = time.getText().toString();


                Boolean checkinsertdata = myDB.addSub(Sub,Room,Teacher,wDAy,No,time1);
                if (checkinsertdata == true) {
                    Toast.makeText(Add_Form.this, "Added", Toast.LENGTH_SHORT).show();
                    goList3();
                }else
                    Toast.makeText(Add_Form.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        wDAy = text;
        // dayT.setText(text);
        // Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public  void  goList3(){
        Intent intent2 = new Intent(Add_Form.this,Monday.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}