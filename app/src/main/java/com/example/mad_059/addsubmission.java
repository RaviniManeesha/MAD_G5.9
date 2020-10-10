package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class addsubmission extends AppCompatActivity {
    TextView txtName,txtDay,txtTime,txtNote,txtRegNo,txtmName;
    Button btnDone;
    DBHelper DB;
    String  No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsubmission);

        txtName = findViewById(R.id.sName);
        txtTime= findViewById(R.id.rTime);
        txtNote = findViewById(R.id.Note);
        txtRegNo = findViewById(R.id.id);
        txtmName = findViewById(R.id.mName);
        txtDay = findViewById(R.id.Date);
        btnDone = findViewById(R.id.Done);

        //get  RegNo
        DB = new DBHelper(this);
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String currentDate = sdf.format(new Date());

        //add data
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(txtName.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Submission Name", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txtmName.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Module Name", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txtDay.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Day", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txtTime.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Time", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txtNote.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Note", Toast.LENGTH_SHORT).show();
                }else {
                    String Name = txtName.getText().toString();
                    String Day = txtDay.getText().toString();
                    String Time = txtTime.getText().toString();
                    String Note = txtNote.getText().toString();
                    String mCode = txtmName.getText().toString();
                    String RegNO = txtRegNo.getText().toString();

                    Boolean checkinsertdata2 = DB.insertSub(Name, Day, Time, Note, mCode, RegNO);
                    if (checkinsertdata2 == true) {
                        Toast.makeText(addsubmission.this, "Add New Submission Successfully!", Toast.LENGTH_SHORT).show();
                        goSub();

                    } else
                        Toast.makeText(addsubmission.this, "Adding Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public  void  goSub(View view){
        Intent intent1 = new Intent(addsubmission.this,submissions.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }

    public  void  goSub(){
        Intent intent2 = new Intent(addsubmission.this,submissions.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    void calcDate () {


    }
}