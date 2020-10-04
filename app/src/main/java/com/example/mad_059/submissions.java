package com.example.mad_059;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class submissions extends AppCompatActivity {

    TextView txtRegNo,txtSid,txtDate,txtDay;
    DBHelper DB;
    RecyclerView recyclerView;
    ArrayList<String> sid, sName, Day,Time,Note,mName,RegNo;
    CustomAdapter customAdapter;
    String No;
    String subDate,Day1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submissions);



        recyclerView = findViewById(R.id.recyclerView);
        txtRegNo = findViewById(R.id.id);
        txtSid = findViewById(R.id.sid);
        txtDate = findViewById(R.id.today);
        txtDay = findViewById(R.id.textView29);

        DB = new DBHelper(submissions.this);
        //get passing ID
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);


        sid = new ArrayList<>();
        sName = new ArrayList<>();
        Day = new ArrayList<>();
        Time = new ArrayList<>();
        mName = new ArrayList<>();
        Note = new ArrayList<>();
        RegNo = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(submissions.this,this, sid, sName, Day,Time,Note,mName,RegNo);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(submissions.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    public  void  goProfile(View view){
        Intent intent1 = new Intent(submissions.this,profile.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }

    public void addSub(View view){
        Intent intent1 = new Intent(submissions.this,addsubmission.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }

    void storeDataInArrays(){

        Cursor cursor = DB.readAllData(No);
        if(cursor.getCount() == 0){

        }else{
            while (cursor.moveToNext()){
                sid.add(cursor.getString(0));
                sName.add(cursor.getString(1));
               // Day.add(cursor.getString(2));
               Time.add(cursor.getString(3));
               Note.add(cursor.getString(4));
               mName.add(cursor.getString(5));
                RegNo.add(cursor.getString(6));
            }
        }
    }




}