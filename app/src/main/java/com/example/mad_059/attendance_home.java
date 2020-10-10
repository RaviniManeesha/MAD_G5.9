package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mad_059.Database.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class attendance_home extends AppCompatActivity {
    String No;
    TextView txtRegNo;

    RecyclerView recyclerView;
    FloatingActionButton Add_button;
    DBHelper myDB;
    ArrayList<String> sub_id, subject, room, teacher,day,RegNo,time;
    StudentAdapter studentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_home);


        recyclerView = findViewById(R.id.recyclerView);
        Add_button = findViewById(R.id.Add_button);

        txtRegNo = findViewById(R.id.reg);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);


        txtRegNo = findViewById(R.id.reg);
        myDB = new DBHelper(attendance_home.this);

        Add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(attendance_home.this, add_attendance.class);
                intent.putExtra("RegNo", txtRegNo.getText().toString());
                startActivity(intent);
            }
        });

        myDB = new DBHelper(attendance_home.this);
        sub_id = new ArrayList<>();
        subject = new ArrayList<>();
        room = new ArrayList<>();
        teacher = new ArrayList<>();
        day = new ArrayList<>();
        time = new ArrayList<>();
        RegNo = new ArrayList<>();


        storeDataArrays();

        studentAdapter = new StudentAdapter(attendance_home.this, this, sub_id, subject, room, teacher,day,time,RegNo);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(attendance_home.this));

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }
    public void goMain(View view){
        Intent intent1 = new Intent(this,profile.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }

    public void Addatten(View view){
        Intent intent1 = new Intent(this,add_attendance.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }
    void storeDataArrays() {
        Cursor cursor = myDB.readAllData2(No);
        if (cursor.getCount() == 0) {


        } else {
            while (cursor.moveToNext()) {
                sub_id.add(cursor.getString(0));
                subject.add(cursor.getString(1));
                room.add(cursor.getString(2));
                teacher.add(cursor.getString(3));
                day.add(cursor.getString(4));
                time.add(cursor.getString(6));
                RegNo.add(cursor.getString(5));
            }

        }
    }
}