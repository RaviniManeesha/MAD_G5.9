package com.example.mad_059;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class updatebook extends AppCompatActivity {


    String title,edate,bdate,RegNo,id;
    TextView txtTitle,txteDate,txtbDate,txtRegNo,txtID;
    Button btnUpdate;
    Integer ID,BID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatebook);


        txtTitle = findViewById(R.id.title_input2);
        txtbDate = findViewById(R.id.dateB_input2);
        txteDate = findViewById(R.id.dateE_input2);
        txtRegNo = findViewById(R.id.reg);

        getAndSetIntentData();
    }
    void  getAndSetIntentData(){

        if(getIntent().hasExtra("ID" ) && getIntent().hasExtra("title") && getIntent().hasExtra("bdate")
                && getIntent().hasExtra("edate") && getIntent().hasExtra("RegNo")){
            id = getIntent().getStringExtra("ID");
            title = getIntent().getStringExtra("title");
            bdate = getIntent().getStringExtra("bdate");
            edate= getIntent().getStringExtra("edate");
            RegNo = getIntent().getStringExtra("RegNo");

            txtTitle.setText(title);
            txtbDate.setText(bdate);
            txteDate.setText(edate);
            txtRegNo.setText(RegNo);

            BID = Integer.parseInt(id);

        }else{
            Toast.makeText(this,"No data ",Toast.LENGTH_SHORT).show();
        }
    }

    public void openEdit(View view){
        DBHelper myDB = new DBHelper(updatebook.this);
        title = txtTitle.getText().toString();
        bdate = txtbDate.getText().toString();
        edate = txteDate.getText().toString();



        Boolean checkupdatedata =  myDB.UpdateData3(BID,title,bdate,edate);
        if (checkupdatedata == true) {
            Toast.makeText(updatebook.this, " Successfully Updated!", Toast.LENGTH_SHORT).show();
            goBook();
        } else
            Toast.makeText(updatebook.this, " Failed to Update!", Toast.LENGTH_SHORT).show();
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete  " + title + "?");
        builder.setMessage(" Are you sure you want to delete " + title + " ? " );
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelper myDB = new DBHelper(updatebook.this);

                Boolean checkupdatedata = myDB.deleteBook3( BID );
                if (checkupdatedata == true) {
                    Toast.makeText(updatebook.this, " Successfully Deleted", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(updatebook.this, " Failed", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    public  void goDelete(View view){
        confirmDialog();
    }

    public  void  goBook(){
        Intent intent2 = new Intent(updatebook.this,booklist.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }
}