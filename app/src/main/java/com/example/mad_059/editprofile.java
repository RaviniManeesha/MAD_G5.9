package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mad_059.Database.DBHelper;


public class editprofile extends AppCompatActivity {

    TextView txtRegNo,txtName,txtEmail,txtPhone,txtDate;
    DBHelper DB;
    String RegNo,Name,Phone,Email,Date,No;
    Integer ID;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        txtRegNo =  findViewById(R.id.regno);
        txtName =  findViewById(R.id.name);
        txtPhone =  findViewById(R.id.phone);
        txtDate =  findViewById(R.id.date);
        txtEmail =  findViewById(R.id.email);

        //view data
        DB = new DBHelper(this);
        Intent intent = getIntent();

        No = intent.getStringExtra("RegNo");

        Cursor cursor = DB.getData(No);
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                ID = Integer.valueOf(cursor.getString(0));
                RegNo = cursor.getString(1);
                Name =  cursor.getString(3);
                Phone = cursor.getString(4);
                Email = cursor.getString(5);
                Date = cursor.getString(6);
            }
        }

        txtRegNo.setText(RegNo);
        txtName.setText(Name);
        txtPhone.setText(Phone);
        txtEmail.setText(Email);
        txtDate.setText(Date);

        //update data
        btnUpdate = findViewById(R.id.btndone2);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String RegNo = txtRegNo.getText().toString();
                String Name = txtName.getText().toString();
                String Phone = txtPhone.getText().toString();
                String Date = txtDate.getText().toString();
                String Email = txtEmail.getText().toString();


                Boolean checkupdatedata = DB.UpdateData(ID,RegNo, Name, Phone,Email,Date);
                if(checkupdatedata==true) {
                    Toast.makeText(editprofile.this, " Updated User Details", Toast.LENGTH_SHORT).show();
                    openDone();
                }else
                    Toast.makeText(editprofile.this, " Not Updated User Details", Toast.LENGTH_SHORT).show();
            }        });
    }

    public void openDone(){
        Intent intent1 = new Intent(this,viewprofile.class);
        intent1.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent1);
    }

    public void goBack3(View view){
        Intent intent2 = new Intent(this,viewprofile.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public void  openEditPwd(View view){
        Intent intent3 = new Intent(this,updatepwd.class);
        intent3.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent3);
    }
}