package com.example.mad_059;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class booklist extends AppCompatActivity {

    TextView txtTitleIn, txtDateBIn, txtDateEIn;
    DBHelper DB;
    RecyclerView recyclerView;
    ArrayList<String> ID,title,dateB,dateE,RegNo;
    BookAdapter BookAdapter;
    String No;

    TextView txtRegNo;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);

        recyclerView =findViewById(R.id.recyclerView);
        txtDateBIn = findViewById(R.id.txtDateBIn);

        txtRegNo = findViewById(R.id.reg);
        myDB = new DBHelper(booklist.this);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);

        DB = new DBHelper(booklist.this);
        ID = new ArrayList<>();
        title= new ArrayList<>();
        dateB= new ArrayList<>();
        dateE= new ArrayList<>();
        RegNo = new ArrayList<>();

        storeDataInArrays();

        BookAdapter = new BookAdapter(booklist.this,this, ID,title,dateB,dateE,RegNo);
        recyclerView.setAdapter(BookAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(booklist.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }


    public  void  AddBook(View view){
        Intent intent2 = new Intent(booklist.this,addbook.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public  void goBack6(View view){
        Intent intent2 = new Intent(booklist.this,profile.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
    void storeDataInArrays(){
        Cursor cursor = DB.getData3(No);
        if(cursor.getCount() == 0) {
        }else{
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                title.add(cursor.getString(1));
                dateB.add(cursor.getString(2));
                dateE.add(cursor.getString(3));
                RegNo.add(cursor.getString(4));
            }
        }
    }

}