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

public class updatepwd extends AppCompatActivity {

    TextView txtOldPwd,txtNewPwd,txtConPwd,txtRegNo;
    Button btnUpdate;
    DBHelper DB;
    String DPwd,No,TPwd,CPwd,NPwd;
    Integer ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepwd);

        txtOldPwd =  findViewById(R.id.oldpwd2);
        txtNewPwd =  findViewById(R.id.newpwd2);
        txtConPwd =  findViewById(R.id.cpwd2);
        txtRegNo = findViewById(R.id.reg);
        btnUpdate = findViewById(R.id.btnUp);

        DB = new DBHelper(this);
        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        txtRegNo.setText(No);

        //get data
        Cursor cursor = DB.getData(No);
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();
        }else{

            while(cursor.moveToNext()){
                ID = Integer.valueOf(cursor.getString(0));
                DPwd = cursor.getString(2);
            }
        }

        //update data
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TPwd = txtOldPwd.getText().toString();
                CPwd = txtConPwd.getText().toString();
                NPwd = txtNewPwd.getText().toString();

                if(TPwd.equals(DPwd) ){

                    if( CPwd.equals(NPwd)){

                        Boolean checkupdatedata = DB.UpdateUserPwd(ID, NPwd);
                        if (checkupdatedata == true) {
                            Toast.makeText(updatepwd.this, " Updated User Details", Toast.LENGTH_SHORT).show();
                            openProfile();

                        } else
                            Toast.makeText(updatepwd.this, " Not Updated User Details", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(updatepwd.this, "Confirm Password is not Match to Confirm Password!", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(updatepwd.this, "Old Password is Not Match!", Toast.LENGTH_SHORT).show();
                }







            }
        });


    }

    public  void openProfile()
    {
        Intent intent1 = new Intent(updatepwd.this,viewprofile.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }

    public  void goProfile(View view)
    {
        Intent intent1 = new Intent(updatepwd.this,editprofile.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }

}