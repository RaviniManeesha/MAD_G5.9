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

public class editsubmission extends AppCompatActivity {

    TextView txtName,txtDay,txtTime,txtNote;
    Button btnDone;
    DBHelper DB;
    String Name,Day,Time,Note;
    Integer SID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsubmission);

      txtName = findViewById(R.id.subName);
      txtDay = findViewById(R.id.Day);
      txtTime= findViewById(R.id.Time);
      txtNote = findViewById(R.id.Note);
      btnDone = findViewById(R.id.btnEdit);

        //view data
        DB = new DBHelper(this);

        Cursor cursor = DB.getsData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                SID = Integer.valueOf(cursor.getString(0));
                Name = cursor.getString(1);
                Day =  cursor.getString(2);
                Time = cursor.getString(3);
                Note = cursor.getString(4);

            }
        }

        txtName.setText(Name);
        txtDay.setText(Day);
        txtTime.setText(Time);
        txtNote.setText(Note);

        //update data
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = txtName.getText().toString();
                String Day = txtDay.getText().toString();
                String Time = txtTime.getText().toString();
                String Note = txtNote.getText().toString();


                Boolean checkupdatedata = DB.UpdateSub(SID, Name, Day, Time, Note);
                if (checkupdatedata == true) {
                    Toast.makeText(editsubmission.this, " Updated Submission Details", Toast.LENGTH_SHORT).show();
                    openSub();
                } else
                    Toast.makeText(editsubmission.this, " Not Updated Submission Details", Toast.LENGTH_SHORT).show();
            }        });
    }

    public  void goSub(View view){
        Intent intent1 = new Intent(editsubmission.this,submission.class);
        startActivity(intent1);

    }

    public  void openSub(){
        Intent intent2 = new Intent(editsubmission.this,submission.class);
        startActivity(intent2);

    }

}