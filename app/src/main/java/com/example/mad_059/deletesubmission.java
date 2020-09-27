package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class deletesubmission extends AppCompatActivity {
    TextView txtName,txtDay,txtTime,txtNote,txtID;
    Button btnDelete;
    DBHelper DB;
    String Name,Day,Time,Note;
    Integer SID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletesubmission);

        txtName = findViewById(R.id.Name);
        txtDay = findViewById(R.id.Day);
        txtTime= findViewById(R.id.Time);
        txtNote = findViewById(R.id.Note);
        btnDelete = findViewById(R.id.btnDelete);

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


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean checkudeletedata = DB.deleteSub(SID);
                if(checkudeletedata==true)
                    Toast.makeText(deletesubmission.this, "Delete Submission", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(deletesubmission.this, "Not Deleted Submission", Toast.LENGTH_SHORT).show();
            }        });
    }
}