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

    RecyclerView recyclerView1;
    FloatingActionButton addDetailsBtn;
    TextView txtRegNo;
    String No;
    DBHelper myDB;
    MDetailsAdapter detailsAdapter;

    ArrayList<String> modID, modName, modCode, noOfCredits, caMarks, fMarks, ref,RegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailslist);

        recyclerView1 = findViewById(R.id.res1);
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

        myDB = new DBHelper(detailslist.this);
        modID = new ArrayList<>();
        modName = new ArrayList<>();
        modCode = new ArrayList<>();
        noOfCredits = new ArrayList<>();
        caMarks = new ArrayList<>();
        fMarks = new ArrayList<>();
        ref = new ArrayList<>();
        RegNo = new ArrayList<>();

        storeDataInArrays();
        detailsAdapter = new MDetailsAdapter(detailslist.this,this, modID, modName, modCode, noOfCredits, caMarks, fMarks, ref,RegNo);
        recyclerView1.setAdapter(detailsAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(detailslist.this));


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

        if(cursor.getCount() == 00){

        }
        else{
            while (cursor.moveToNext()){
                modID.add(cursor.getString(0));
                modCode.add(cursor.getString(1));
                modName.add(cursor.getString(2));
                noOfCredits.add(cursor.getString(3));
                caMarks.add(cursor.getString(4));
                fMarks.add(cursor.getString(5));
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