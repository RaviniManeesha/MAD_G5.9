package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class addsubmissison extends AppCompatActivity {

    TextView txtName,txtDay,txtTime,txtNote,txtRegNo,txtmCode;
    TextView btnDone;
    DBHelper DB;
    String  RegNo,mCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addsubmissison);

        txtName = findViewById(R.id.sName);
        txtDay = findViewById(R.id.rDay);
        txtTime= findViewById(R.id.rTime);
        txtNote = findViewById(R.id.Note);
        txtRegNo = findViewById(R.id.RegNo);
        txtmCode = findViewById(R.id.mCode);
        btnDone = findViewById(R.id.Done);

        //get mCode and RegNo
        DB = new DBHelper(this);
        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                RegNo = cursor.getString(1);
            }
        }

        txtRegNo.setText(RegNo);

        Cursor cursor2 = DB.getmData();
        if(cursor2.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor2.moveToNext()){
                mCode = cursor2.getString(2);
            }
        }

        txtmCode.setText(mCode);

        //add data
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String Name = txtName.getText().toString();
                    String Day = txtDay.getText().toString();
                    String Time = txtTime.getText().toString();
                    String Note = txtNote.getText().toString();
                    String mCode = txtmCode.getText().toString();
                    String RegNO = txtRegNo.getText().toString();


                    Boolean checkinsertdata2 = DB.insertSub(Name,Day,Time,Note, mCode, RegNO);
                    if (checkinsertdata2 == true) {
                        Toast.makeText(addsubmissison.this, "Add New Module Successfully!", Toast.LENGTH_SHORT).show();


                    } else
                        Toast.makeText(addsubmissison.this, "Adding Unsuccessful!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}