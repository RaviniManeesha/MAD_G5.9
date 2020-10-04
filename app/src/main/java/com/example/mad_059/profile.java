package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class profile extends AppCompatActivity {

    TextView txtRegNo,txtName,txtNo;
    DBHelper DB;
    String  RegNo,Name,No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtRegNo = findViewById(R.id.Rnumber);
        txtName = findViewById(R.id.stName);
        txtNo = findViewById(R.id.regno);

        DB = new DBHelper(this);

        //get passing ID
        Intent intent = getIntent();

        No = intent.getStringExtra("RegNo");

        //get data
        Cursor cursor = DB.getData(No);
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                RegNo = cursor.getString(1);
                Name = cursor.getString(3);

            }
        }
        txtRegNo.setText(RegNo);
        txtName.setText(Name);
    }

    public void openLogout(View view){
        Intent intent1 = new Intent(this,login.class);
        startActivity(intent1);
    }
    public void openSubmissions(View view){
        Intent intent2 = new Intent(this,submissions.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
    public void openInformation(View view){
        Intent intent3 = new Intent(this,information.class);
        intent3.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent3);
    }
    public  void  viewProfile(View view){
        Intent intent2 = new Intent(profile.this,viewprofile.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public  void  goAttendance(View view){
        Intent intent2 = new Intent(profile.this,attendance_main.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public  void  goLibrary(View view){
        Intent intent2 = new Intent(profile.this,booklist.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public  void  goModules(View view){
        Intent intent2 = new Intent(profile.this,module_main.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public  void  goFees(View view){
        Intent intent2 = new Intent(profile.this,fees_main.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}