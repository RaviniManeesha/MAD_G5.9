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

import com.example.mad_059.Database.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class detailslist extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addDetailsBtn;
    TextView txtRegNo;
    String No;
    DBHelper myDB;
    MDetailsAdapter detailsAdapter;

    ArrayList<String> name, code, cr,RegNo,ca,fn,ref,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailslist);

        recyclerView = findViewById(R.id.res1);
        addDetailsBtn = findViewById(R.id.addDetailsBtn);

        //get passing ID
        txtRegNo = findViewById(R.id.reg);
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);

        addDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(detailslist.this,adddetails.class);
                intent.putExtra("RegNo", txtRegNo.getText().toString());
                startActivity(intent);
            }
        });




    }
    @Override
    protected void onActivityResult(int requestcode, int resultcode, @Nullable Intent data) {
        super.onActivityResult(requestcode, resultcode, data);

        if (requestcode == 1){
            recreate();
        }else{

        }
    }

    void storeDataInArrays(){

        Cursor cursor = myDB.readAllDetails4(No);

        if(cursor.getCount() == 0){

        }
        else{
            while (cursor.moveToNext()){
                no.add(cursor.getString(0));
                name.add(cursor.getString(1));
                code.add(cursor.getString(2));
                cr.add(cursor.getString(3));
                ca.add(cursor.getString(4));
                fn.add(cursor.getString(5));
                ref.add(cursor.getString(6));
                RegNo.add(cursor.getString(7));

            }
        }
    }
    public  void goBac9(View view){
        Intent intent2 = new Intent(detailslist.this,module_main.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }





}