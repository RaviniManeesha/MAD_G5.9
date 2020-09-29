package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class module extends AppCompatActivity {

    TextView txtmCode,txtmName;
    DBHelper DB;
    String  Name,Code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        txtmCode = findViewById(R.id.mName);
        txtmName = findViewById(R.id.mCode);

        DB = new DBHelper(this);
        Cursor cursor = DB.getmData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                Name =  cursor.getString(1);
                Code =  cursor.getString(2);

            }
        }

        txtmName.setText(Name);
        txtmCode.setText(Code);
    }

    public  void  openMEdit(View view){

        Intent intent1 = new Intent(module.this,editmodule.class);
        startActivity(intent1);
    }

    public  void  openMDelete(View view){
        Intent intent2 = new Intent(module.this,deletemodule.class);
        startActivity(intent2);
    }



}