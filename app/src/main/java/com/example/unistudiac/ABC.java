package com.example.unistudiac;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ABC extends AppCompatActivity {
    RecyclerView recyclerView1;
    FloatingActionButton btnAdd;

    MyDatabaseHelper myDB;
    ArrayList<String> modID, modName, modCode, noOfCredits, caMarks, fMarks, ref;
    AdapterDetails detailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_b_c);

        recyclerView1 = findViewById(R.id.res1);
        btnAdd = findViewById(R.id.addDetailsBtn);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ABC.this,AddDetails.class);
                startActivity(i);
            }
        });

        myDB = new MyDatabaseHelper(ABC.this);
        modID = new ArrayList<>();
        modName = new ArrayList<>();
        modCode = new ArrayList<>();
        noOfCredits = new ArrayList<>();
        caMarks = new ArrayList<>();
        fMarks = new ArrayList<>();
        ref = new ArrayList<>();

        storeDataInArrays();
        detailsAdapter = new AdapterDetails(ABC.this,this, modID, modName, modCode, noOfCredits, caMarks, fMarks, ref);
        recyclerView1.setAdapter(detailsAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(ABC.this));
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

        Cursor cursor = myDB.readAllDetails();

        if(cursor.getCount() == 00){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                modID.add(cursor.getString(0));
                modName.add(cursor.getString(1));
                modCode.add(cursor.getString(2));
                noOfCredits.add(cursor.getString(3));
                caMarks.add(cursor.getString(4));
                fMarks.add(cursor.getString(5));
                ref.add(cursor.getString(6));
            }
        }
    }
}