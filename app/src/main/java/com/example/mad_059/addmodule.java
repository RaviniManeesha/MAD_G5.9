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

public class addmodule extends AppCompatActivity {

    TextView txtmName ,btnDone;
    DBHelper DB;
    String  RegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmodule);

        txtmName = findViewById(R.id.mName);
        btnDone = findViewById(R.id.textView30);

        DB = new DBHelper(this);
        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                RegNo = cursor.getString(1);
            }
        }

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mName = txtmName.getText().toString();

                Boolean checkinsertdata = DB.insertmData(RegNo,mName);
                if(checkinsertdata==true)
                    Toast.makeText(addmodule.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(addmodule.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });


    }

    public  void goSubmissionCancel(View view) {
        Intent intent1 = new Intent(addmodule.this,viewsubmissions.class);
        startActivity(intent1);

    }

    public  void goSubmissionDone(){
        Intent intent2 = new Intent(addmodule.this,viewsubmissions.class);
        startActivity(intent2);
    }
}