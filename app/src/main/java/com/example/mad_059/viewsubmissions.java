package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class viewsubmissions extends AppCompatActivity {
    TextView txtAll,txtToday,txtSch,txtAdd;


    private Button button6;
    DBHelper DB;
    String  mName;
    Button btnModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewsubmissions);

        txtAll = (TextView) findViewById(R.id.all);
        txtAdd = (TextView) findViewById(R.id.add);
        txtToday = (TextView) findViewById(R.id.today);
        txtSch = (TextView) findViewById(R.id.sch);



    }

    public void openSubmissions(){

        Intent intent7 = new Intent(this,viewmodule.class);
        startActivity(intent7);
    }

    public void openToday(View view ){
        Intent intent1 = new Intent(viewsubmissions.this,today.class);
        startActivity(intent1);

    }

    public void openScheduled(View view){
        Intent intent1 = new Intent(viewsubmissions.this,scheduled.class);
        startActivity(intent1);
    }

    public  void  openAll(View view){
        Intent intent1 = new Intent(viewsubmissions.this,all.class);
        startActivity(intent1);
    }

    public void addModule(View view){
        Intent intent1 = new Intent(viewsubmissions.this,addmodule.class);
        startActivity(intent1);
    }
}