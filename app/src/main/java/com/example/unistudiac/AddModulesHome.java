package com.example.unistudiac;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddModulesHome extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> module_id, module_name, module_no;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module_home);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddModulesHome.this,AddModules.class);
                startActivity(intent);
            }
        });
        myDB = new MyDatabaseHelper(AddModulesHome.this);
        module_id = new ArrayList<>();
        module_name = new ArrayList<>();
        module_no = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(AddModulesHome.this,this, module_id, module_name, module_no);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AddModulesHome.this));
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

        Cursor cursor = myDB.readAllData();

        if(cursor.getCount() == 00){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                module_id.add(cursor.getString(0));
                module_name.add(cursor.getString(1));
                module_no.add(cursor.getString(2));
            }
        }
    }

}