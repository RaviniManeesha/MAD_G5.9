package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class deletesubmission extends AppCompatActivity {

    TextView txtName,txtDay,txtTime,txtNote,txtID,txtmName;
    Button btnDelete;
    DBHelper DB;
    String Name,Day,Time,Note,mName,sid;
    Integer SID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletesubmission);

        txtName = findViewById(R.id.Name);
        txtDay = findViewById(R.id.Day);
        txtTime= findViewById(R.id.Time);
        txtNote = findViewById(R.id.Note);
        txtmName = findViewById(R.id.mname);
        btnDelete = findViewById(R.id.btnDelete);
        txtID = findViewById(R.id.ID);

        //view data
        DB = new DBHelper(this);
        Intent intent = getIntent();
        sid = intent.getStringExtra("sid");
        SID = Integer.parseInt(sid);
        txtID.setText(sid);

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

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean checkudeletedata = DB.deleteSub(SID);
                if(checkudeletedata==true) {
                    Toast.makeText(deletesubmission.this, "Delete Submission", Toast.LENGTH_SHORT).show();
                    openSub();
                }else
                    Toast.makeText(deletesubmission.this, "Not Deleted Submission", Toast.LENGTH_SHORT).show();
            }        });

    }
    public  void openSub(){
        Intent intent2 = new Intent(deletesubmission.this,submissions.class);
        intent2.putExtra("sid", txtID.getText().toString());
        startActivity(intent2);

    }
    public  void Cancel(View view){
        Intent intent2 = new Intent(deletesubmission.this,submission.class);
        intent2.putExtra("sid", txtID.getText().toString());
        startActivity(intent2);

    }
}