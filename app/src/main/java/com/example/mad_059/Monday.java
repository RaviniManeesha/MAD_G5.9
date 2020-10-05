package com.example.mad_059;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Monday extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton Add_button;
    DBHelper myDB;
    ArrayList<String> sub_id, subject, room, teacher,day,RegNo,time;
    StudentAdapter studentAdapter;
    String No;
    TextView txtRegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        recyclerView = findViewById(R.id.recyclerView);
        Add_button = findViewById(R.id.Add_button);


        txtRegNo = findViewById(R.id.reg);
        myDB = new DBHelper(Monday.this);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);

        Add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Monday.this, Add_Form.class);
                intent.putExtra("RegNo", txtRegNo.getText().toString());
                startActivity(intent);
            }
        });

        myDB = new DBHelper(Monday.this);
        sub_id = new ArrayList<>();
        subject = new ArrayList<>();
        room = new ArrayList<>();
        teacher = new ArrayList<>();
        day = new ArrayList<>();
        RegNo = new ArrayList<>();
        time = new ArrayList<>();


        storeDataArrays();

        studentAdapter = new StudentAdapter(Monday.this, this, sub_id, subject, room, teacher,day,RegNo,time);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Monday.this));
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
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
               RegNo.add(cursor.getString(5));
              time.add(cursor.getString(6));
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);

    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All");
        builder.setMessage(" Are you sure you want to delete all data ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelper myDB = new DBHelper(Monday.this);
                myDB.deleteAllData();
                Intent intent = new Intent(Monday.this, Monday.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    public  void  goMain(View view){
        Intent intent2 = new Intent(Monday.this,attendance_main.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}