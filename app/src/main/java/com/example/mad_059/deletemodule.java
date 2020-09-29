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

public class deletemodule extends AppCompatActivity {

    TextView txtmCode,txtmName;
    DBHelper DB;
    String  Name,Code;
    Button btnDelete;
    Integer MID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletemodule);

        txtmCode = findViewById(R.id.mName);
        txtmName = findViewById(R.id.mCode);
        btnDelete = findViewById(R.id.btnDelete);

//view data
        DB = new DBHelper(this);
        Cursor cursor = DB.getmData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                MID = Integer.valueOf(cursor.getString(0));
                Name =  cursor.getString(1);
                Code =  cursor.getString(2);

            }
        }

        txtmName.setText(Name);
        txtmCode.setText(Code);

        //delete data
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean checkudeletedata = DB.deleteModule(MID);
                if(checkudeletedata==true)
                    Toast.makeText(deletemodule.this, "Delete Module", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(deletemodule.this, "Not Deleted Module", Toast.LENGTH_SHORT).show();
            }        });
    }

    public  void Cancel(View view){
        Intent intent1 = new Intent(deletemodule.this,viewmodule.class);
        startActivity(intent1);
    }
}