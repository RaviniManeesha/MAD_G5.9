package com.example.madminiproject;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class viewBookList extends AppCompatActivity {

    TextView txtTitleIn, txtDateBIn, txtDateEIn;
    MyDatabaseHelper DB;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ArrayList<String> ID,title,dateB,dateE;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book_list);

        recyclerView =findViewById(R.id.recyclerView);
        txtTitleIn = findViewById(R.id.txtTitleIn);
        txtDateBIn = findViewById(R.id.txtDateBIn);
        txtDateEIn = findViewById(R.id.txtDateEIn);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewBookList.this,addbook.class);
                startActivity(intent);
            }

        });


        DB = new MyDatabaseHelper(viewBookList.this);
        ID = new ArrayList<>();
        title= new ArrayList<>();
        dateB= new ArrayList<>();
        dateE= new ArrayList<>();
        storeDataInArrays();

        customAdapter = new CustomAdapter(viewBookList.this,this, ID,title,dateB,dateE);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewBookList.this));


    }

    void storeDataInArrays(){
        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No data",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                title.add(cursor.getString(1));
                dateB.add(cursor.getString(2));
                dateE.add(cursor.getString(3));
            }
        }

    }


}