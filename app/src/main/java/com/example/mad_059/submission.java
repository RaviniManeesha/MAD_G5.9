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

public class submission extends AppCompatActivity {

    TextView txtName,txtTime,txtDay,txtNote;
    DBHelper DB;
    String  Name,Day,Time,Note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        txtName = findViewById(R.id.Name);
        txtDay = findViewById(R.id.Day);
        txtTime = findViewById(R.id.Time);
        txtNote = findViewById(R.id.Note);

        DB = new DBHelper(this);
        Cursor cursor = DB.getsData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                Name =  cursor.getString(1);
                Day =  cursor.getString(2);
                Time =  cursor.getString(3);
                Note =  cursor.getString(4);
            }
        }

        txtName.setText(Name);
        txtDay.setText(Day);
        txtTime.setText(Time);
        txtNote.setText(Note);

    }

    public  void openEditS(View view){
        Intent intent1 = new Intent(submission.this,editsubmission.class);
        startActivity(intent1);

    }

    public  void  openDelete(View view){
        Intent intent2 = new Intent(submission.this,deletesubmission.class);
        startActivity(intent2);

    }
}