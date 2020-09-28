package com.example.madminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class deletebook extends AppCompatActivity {
    TextView txttitel,txtdDate,txteDate;
    MyDatabaseHelper DB;
    String title,bDate,eDate;
    Button btnDelete;
    Integer id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletebook);


        txttitel = findViewById(R.id.title_input3);
        txtdDate = findViewById(R.id.dateB_input3);
        txteDate = findViewById(R.id.dateE_input3);
        btnDelete = findViewById(R.id.delete_button);

        //view data
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

    //delete data
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean checkudeletedata = DB.deleteBook(id);
                if(checkudeletedata==true) {
                    Toast.makeText(deletebook.this, "Delete Submission", Toast.LENGTH_SHORT).show();
                    openBookDetails();
                } else
                    Toast.makeText(deletebook.this, "Not Deleted Submission", Toast.LENGTH_SHORT).show();
            }        });

    }

    public  void  openBookDetails(){

        Intent intent1 = new Intent(this,BookDetails.class);
        startActivity(intent1);

    }
}