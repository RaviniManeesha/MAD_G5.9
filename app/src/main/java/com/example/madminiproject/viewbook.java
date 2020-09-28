package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class viewbook extends AppCompatActivity {

    TextView txttitel,txtdDate,txteDate;
    MyDatabaseHelper DB;
    String title,bDate,eDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewbook);

        txttitel = findViewById(R.id.title);
        txtdDate = findViewById(R.id.bDate);
        txteDate = findViewById(R.id.eDate);

        DB = new MyDatabaseHelper(this);
        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
               title = cursor.getString(1);
               bDate = cursor.getString(2);
               eDate = cursor.getString(3);
            }
        }

        txttitel.setText(title);
        txtdDate.setText(bDate);
        txteDate.setText(eDate);
    }

    public  void  goEdit(View view){

        Intent intent1 = new Intent(this,updatebook.class);
        startActivity(intent1);

    }

    public  void  goDelete(View view){

        Intent intent2 = new Intent(this,deletebook.class);
        startActivity(intent2);

    }
}