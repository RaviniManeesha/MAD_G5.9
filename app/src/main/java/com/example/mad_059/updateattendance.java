package com.example.mad_059;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class updateattendance extends AppCompatActivity {

    EditText subject, room, teacher,txtRegNo,txttime;
    Button update_button,delete_button;
    String id,sub,rooms,teachers,RegNo,time1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateattendance);

        subject = findViewById(R.id.Sub_input2);
        room = findViewById(R.id.room_input2);
       txtRegNo = findViewById(R.id.reg);
        teacher = findViewById(R.id.Teacher_input2);
        txttime = findViewById(R.id.clztime);
        update_button = findViewById(R.id.update);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(sub);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DBHelper myDB = new DBHelper(updateattendance.this);
                sub = subject.getText().toString().trim();
                rooms = room.getText().toString().trim();
                teachers = teacher.getText().toString().trim();
                time1 = txttime.getText().toString().trim();
                Boolean checkupdatedata =  myDB.updateData2(id,sub,rooms,teachers,time1);
                if (checkupdatedata == true) {
                Toast.makeText(updateattendance.this, " Successfully Updated", Toast.LENGTH_SHORT).show();
                goList();
            } else
                    Toast.makeText(updateattendance.this, " Failed", Toast.LENGTH_SHORT).show();
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });



    }

    void  getAndSetIntentData(){
        if(getIntent().hasExtra("id" ) && getIntent().hasExtra("subject") && getIntent().hasExtra("room")&& getIntent().hasExtra("teacher") && getIntent().hasExtra("day") && getIntent().hasExtra("time")){

            id=getIntent().getStringExtra("id");
            sub =getIntent().getStringExtra("subject");
            rooms =getIntent().getStringExtra("room");
            teachers =getIntent().getStringExtra("teacher");
            RegNo = getIntent().getStringExtra("RegNo");
            time1 = getIntent().getStringExtra("time");

            subject.setText(sub);
            room.setText(rooms);
            teacher.setText(teachers);
            txtRegNo.setText(RegNo);
            txttime.setText(time1);


        }else{
            Toast.makeText(this,"No data ",Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete" + sub + "?");
        builder.setMessage(" Are you sure you want to delete " + sub + " ? " );
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelper myDB = new DBHelper(updateattendance.this);

                Boolean checkupdatedata = myDB.deleteOneRow2(id);
                if (checkupdatedata == true) {
                    Toast.makeText(updateattendance.this, " Successfully Deleted", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(updateattendance.this, " Failed", Toast.LENGTH_SHORT).show();

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
    public  void  goList(){
        Intent intent2 = new Intent(updateattendance.this,Monday.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}