package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class updatebook extends AppCompatActivity {
    TextView txttitel,txtdDate,txteDate;
    MyDatabaseHelper DB;
    String title,bDate,eDate;
    Button btnUpdate;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatebook);

        txttitel = findViewById(R.id.title_input2);
        txtdDate = findViewById(R.id.dateB_input2);
        txteDate = findViewById(R.id.dateE_input2);
        btnUpdate = findViewById(R.id.update_button);

        DB = new MyDatabaseHelper(this);
        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){
            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                id = Integer.valueOf(cursor.getString(0));
                title = cursor.getString(1);
                bDate = cursor.getString(2);
                eDate = cursor.getString(3);
            }
        }

        txttitel.setText(title);
        txtdDate.setText(bDate);
        txteDate.setText(eDate);

        //update data
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = txttitel.getText().toString();
                String bDate = txtdDate.getText().toString();
                String eDate = txteDate.getText().toString();

                Boolean checkupdatedata = DB.UpdateData(id,title,bDate,eDate);
                if(checkupdatedata==true) {
                    Toast.makeText(updatebook.this, " Updated User Details", Toast.LENGTH_SHORT).show();
                    openViewBookList();
                }else
                    Toast.makeText(updatebook.this, " Not Updated User Details", Toast.LENGTH_SHORT).show();
            }        });
    }
    public  void openViewBookList(){
        Intent intent1 = new Intent(this,viewBookList.class);
        startActivity(intent1);
    }
}