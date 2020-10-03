package com.example.mad_059;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_059.Database.DBHelper;

public class submission extends AppCompatActivity {
    TextView txtName,txtTime,txtDay,txtNote,txtmName,txtID,txtRegNo;
    DBHelper DB;
    String  Name,Day,Time,Note,mName,sid,No;
    Integer SID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        txtRegNo = findViewById(R.id.id);
        txtName = findViewById(R.id.Name);
        txtDay = findViewById(R.id.Day);
        txtTime = findViewById(R.id.Time);
        txtNote = findViewById(R.id.Note);
        txtmName = findViewById(R.id.mname);
        txtID = findViewById(R.id.sid);

        DB = new DBHelper(this);
        //get passing ID
        Intent intent = getIntent();

        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);
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

    }

    public  void openEditS(View view){
        Intent intent1 = new Intent(submission.this, editsubmission.class);
        intent1.putExtra("sid", txtID.getText().toString());
        startActivity(intent1);
    }

    public  void openDeleteS(View view){
        confirmDialog();
    }

    public  void  gosub(View view){
        Intent intent3 = new Intent(submission.this, submissions.class);

        startActivity(intent3);

    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete  " + Name + "?");
        builder.setMessage(" Are you sure you want to delete " + Name + " ? " );
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelper myDB = new DBHelper(submission.this);

                Boolean checkupdatedata = myDB.deleteSub( SID );
                if (checkupdatedata == true) {
                    Toast.makeText(submission.this, " Successfully Deleted", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(submission.this, " Failed", Toast.LENGTH_SHORT).show();

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