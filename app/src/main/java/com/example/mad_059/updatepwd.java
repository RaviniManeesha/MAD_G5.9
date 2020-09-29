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

    TextView txtOldPwd,txtNewPwd,txtConPwd;
    Button btnUpdate;
    DBHelper DB;
    String Pwd;
    Integer ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepwd);

        txtOldPwd =  findViewById(R.id.oldpwd);
        txtNewPwd =  findViewById(R.id.newpwd);
        txtConPwd =  findViewById(R.id.cpwd);
        btnUpdate = findViewById(R.id.btnUp);

        DB = new DBHelper(this);
        //get data
        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                ID = Integer.valueOf(cursor.getString(0));
                Pwd = cursor.getString(2);

            }
        }

        txtOldPwd.setText(Pwd);


        //update data
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pwd = txtNewPwd.getText().toString();

                Boolean checkupdatedata = DB.UpdateUserPwd(ID, Pwd);
                if (checkupdatedata == true) {
                    Toast.makeText(updatepwd.this, " Updated User Details", Toast.LENGTH_SHORT).show();
                    openProfile();

                } else
                    Toast.makeText(updatepwd.this, " Not Updated User Details", Toast.LENGTH_SHORT).show();
            }        });


    }

    public  void openProfile()
    {
        Intent intent1 = new Intent(updatepwd.this,viewprofile.class);
        startActivity(intent1);
    }

    public  void goProfile(View view)
    {
        Intent intent1 = new Intent(updatepwd.this,editprofile.class);
        startActivity(intent1);
    }

}