package com.example.attendancecriteria;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText subject, room, teacher,time;
    Spinner day;
    Button update_button,delete_button;

    String id,sub,rooms,teachers,day1,time2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        subject = findViewById(R.id.Sub_input2);
        room = findViewById(R.id.room_input2);
        teacher = findViewById(R.id.Teacher_input2);
        time = findViewById(R.id.time);
        update_button = findViewById(R.id.update);
        delete_button = findViewById(R.id.delete_button);
        day =findViewById(R.id.spinner);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(sub);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                sub = subject.getText().toString().trim();
                rooms = room.getText().toString().trim();
                teachers = teacher.getText().toString().trim();
                time2 = time.getText().toString().trim();
                myDB.updateData(id,sub,rooms,teachers,time2);
                finish();
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
        if(getIntent().hasExtra("id" ) && getIntent().hasExtra("subject") && getIntent().hasExtra("room")&& getIntent().hasExtra("teacher")&& getIntent().hasExtra("time")){
            id=getIntent().getStringExtra("id");
            sub =getIntent().getStringExtra("subject");
            rooms =getIntent().getStringExtra("room");
            teachers =getIntent().getStringExtra("teacher");
            time2 =getIntent().getStringExtra("time");

            subject.setText(sub);
            room.setText(rooms);
            teacher.setText(teachers);
            time.setText(time2);


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
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
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
}