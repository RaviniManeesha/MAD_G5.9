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

public class modulelist extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    DBHelper myDB;
    ArrayList<String> module_id, module_name, module_no,RegNo;
    ModuleAdapter moduleAdapter;
    TextView txtRegNo;
    String No;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulelist);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);

        //get passing ID
        txtRegNo = findViewById(R.id.reg);
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(modulelist.this,AddModules.class);
                intent.putExtra("RegNo", txtRegNo.getText().toString());
                startActivity(intent);
            }
        });
        myDB = new DBHelper(modulelist.this);
        module_id = new ArrayList<>();
        module_name = new ArrayList<>();
        module_no = new ArrayList<>();
        RegNo = new ArrayList<>();

        storeDataInArrays();
        moduleAdapter = new ModuleAdapter(modulelist.this,this, module_id, module_name, module_no,RegNo);
        recyclerView.setAdapter(moduleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(modulelist.this));
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

        Cursor cursor = myDB.readAllData4(No);

        if(cursor.getCount() == 00){

        }
        else{
            while (cursor.moveToNext()){
                module_id.add(cursor.getString(0));
                module_name.add(cursor.getString(1));
                module_no.add(cursor.getString(2));
                RegNo.add(cursor.getString(3));
            }
        }
    }
    public  void goBack7(View view){
        Intent intent2 = new Intent(modulelist.this,module_main.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}