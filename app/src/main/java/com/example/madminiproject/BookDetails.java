package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookDetails extends AppCompatActivity {

    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);


    }

    public  void  addBook(View view){

        Intent intent1 = new Intent(this,addbook.class);
        startActivity(intent1);

    }

    public  void  viewBook(View view){

        Intent intent2 = new Intent(this,viewbook.class);
        startActivity(intent2);

    }

}