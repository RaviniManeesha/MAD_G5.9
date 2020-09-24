package com.example.mad_059;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mad_059.Database.DBHelper;


public class viewprofile extends AppCompatActivity {

    TextView txtRegNo,txtPwd,txtName,txtEmail,txtPhone,txtDate;
    DBHelper DB;
    String RegNo,Pwd,Name,Phone,Email,Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        txtRegNo =  findViewById(R.id.regno);
        txtName =  findViewById(R.id.name);
        txtPwd =  findViewById(R.id.password);
        txtPhone =  findViewById(R.id.phone);
        txtDate =  findViewById(R.id.date);
        txtEmail =  findViewById(R.id.email);

        DB = new DBHelper(this);

        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                RegNo = cursor.getString(1);
                Pwd = cursor.getString(2);
                Name =  cursor.getString(3);
                Phone = cursor.getString(4);
                Email = cursor.getString(5);
                Date = cursor.getString(6);
            }
        }

        txtRegNo.setText(RegNo);
        txtName.setText(Name);
        txtPwd.setText(Pwd);
        txtPhone.setText(Phone);
        txtEmail.setText(Email);
        txtDate.setText(Date);


    }

    public void openEdit(View view){
        Intent intent1 = new Intent(this,editprofile.class);
        startActivity(intent1);
    }

    public void goBack1(View view){
        Intent intent2 = new Intent(viewprofile.this,profile.class);
        startActivity(intent2);
    }

}