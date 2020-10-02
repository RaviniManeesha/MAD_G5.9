package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class resetpwd2 extends AppCompatActivity {

    Button btnReset;
    TextView txtCon,txtNew;
    DBHelper DB;
    Integer ID;
    String No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpwd2);

        btnReset = findViewById(R.id.reset);
        txtNew = findViewById(R.id.newpwd);
        txtCon = findViewById(R.id.cpwd);


        DB = new DBHelper(this);

        Intent intent = getIntent();
        No = intent.getStringExtra("RegNo");
        //get data
        Cursor cursor = DB.getData(No);
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();
        }else{

            while(cursor.moveToNext()){
                ID = Integer.valueOf(cursor.getString(0));
            }
        }


        //reset pwd
       btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pwd = txtNew.getText().toString();
                String cPwd = txtCon.getText().toString();

                if(Pwd.equals(cPwd)) {
                    Boolean checkupdatedata = DB.UpdateUserPwd(ID, Pwd);
                    if (checkupdatedata == true) {
                        Toast.makeText(resetpwd2.this, " Reset Password!", Toast.LENGTH_SHORT).show();
                        openLogin();

                    } else
                        Toast.makeText(resetpwd2.this, " Not Reset Password!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(resetpwd2.this, " New Password is not equal to Confirm Password", Toast.LENGTH_SHORT).show();
                }

                }        });
    }


    public void openLogin(){
        Intent intent1 = new Intent(this,login.class);
        startActivity(intent1);
    }
}