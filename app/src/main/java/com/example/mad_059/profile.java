package com.example.mad_059;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    TextView txtRegNo,txtName;
    DBHelper DB;
    String  RegNo,Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtRegNo = findViewById(R.id.Rnumber);
        txtName = findViewById(R.id.stName);

        DB = new DBHelper(this);
        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
              RegNo = cursor.getString(1);
              Name =  cursor.getString(3);
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

        Intent intent2 = new Intent(this,viewsubmissions.class);
        startActivity(intent2);


    }

    public void openInformation(View view){

        Intent intent3 = new Intent(this,information.class);
        startActivity(intent3);


    }

    public  void  viewProfile(View view){
        Intent intent2 = new Intent(profile.this,viewprofile.class);
        startActivity(intent2);
    }

}