package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class editsubmission extends AppCompatActivity {

    Button btnDone;
    TextView txtName,txtTime,txtDay,txtNote,txtmName,txtID;
    DBHelper DB;
    String  Name,Day,Time,Note,mName;
    Integer SID;
    String sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsubmission);

        txtName = findViewById(R.id.subName);
        txtDay = findViewById(R.id.Day);
        txtTime= findViewById(R.id.Time);
        txtNote = findViewById(R.id.Note);
        txtmName = findViewById(R.id.mName);
        txtID = findViewById(R.id.id);
        btnDone = findViewById(R.id.btnEdit);

        DB = new DBHelper(this);
        //get passing ID
        Intent intent = getIntent();
        sid = intent.getStringExtra("sid");
        txtID.setText(sid);
        SID = Integer.parseInt(sid);
        //get data
        Cursor cursor = DB.getSub(SID);
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                SID = Integer.valueOf(cursor.getString(0));
                Name= cursor.getString(1);
                Day = cursor.getString(2);
                Time =  cursor.getString(3);
                Note =  cursor.getString(4);
                mName =  cursor.getString(5);
            }
        }

        txtName.setText(Name);
        txtDay.setText(Day);
        txtTime.setText(Time);
        txtNote.setText(Note);
        txtmName.setText(mName);


        //update data
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = txtName.getText().toString();
                String Day = txtDay.getText().toString();
                String Time = txtTime.getText().toString();
                String Note = txtNote.getText().toString();
                String mName = txtmName.getText().toString();


                Boolean checkupdatedata = DB.UpdateSub(sid, Name, Day, Time, Note,mName);
                if (checkupdatedata == true) {
                    Toast.makeText(editsubmission.this, " Updated Submission Details", Toast.LENGTH_SHORT).show();
                    openSub();
                } else
                    Toast.makeText(editsubmission.this, " Not Updated Submission Details", Toast.LENGTH_SHORT).show();
            }        });
    }

    public  void openSub(){
        Intent intent2 = new Intent(editsubmission.this,submission.class);
        intent2.putExtra("sid", txtID.getText().toString());
        startActivity(intent2);

    }

    public  void goBack(View view){
        Intent intent2 = new Intent(editsubmission.this,submission.class);
        intent2.putExtra("sid", txtID.getText().toString());

        startActivity(intent2);

    }


}