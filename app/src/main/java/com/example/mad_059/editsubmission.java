package com.example.mad_059;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class editsubmission extends AppCompatActivity {

    Button btnDone;
    TextView txtName,txtTime,txtDay,txtNote,txtmName,txtRegNo;
    DBHelper DB;
    String  Name,Day,Time,Note,mName,RegNo,sid;
    Integer SID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editsubmission);

        txtName = findViewById(R.id.subName);
        txtDay = findViewById(R.id.Day);
        txtTime= findViewById(R.id.Time);
        txtNote = findViewById(R.id.Note);
        txtmName = findViewById(R.id.mName);
        txtRegNo = findViewById(R.id.reg);

        DB = new DBHelper(this);
        //get passing ID
        Intent intent = getIntent();

        getAndSetIntentData();

    }


    void getAndSetIntentData(){
        if(getIntent().hasExtra("sid") && getIntent().hasExtra("sName") && getIntent().hasExtra("Day") && getIntent().hasExtra("Time") && getIntent().hasExtra("Note")  && getIntent().hasExtra("mName") && getIntent().hasExtra("RegNo"))
        {
            //Getting data from intent
            sid = getIntent().getStringExtra("sid");
            Name = getIntent().getStringExtra("sName");
            Day = getIntent().getStringExtra("Day");
           Time = getIntent().getStringExtra("Time");
           Note = getIntent().getStringExtra("Note");
           RegNo = getIntent().getStringExtra("RegNo");
           mName = getIntent().getStringExtra("mName");

            //Setting Intent Data

            txtName.setText(Name);
            txtmName.setText(mName);
            txtNote.setText(Note);
            txtTime.setText(Time);
            txtDay.setText(Day);
            txtRegNo.setText(RegNo);

            SID = Integer.parseInt(sid);

        }else{
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }
    }

    public  void EditSub(View view){

        String Name = txtName.getText().toString();
        String Day = txtDay.getText().toString();
        String Time = txtTime.getText().toString();
        String Note = txtNote.getText().toString();
        String mName = txtmName.getText().toString();

        Boolean checkupdatedata = DB.UpdateSub(sid, Name, Day, Time, Note,mName);
        if (checkupdatedata == true) {
            Toast.makeText(editsubmission.this, " Updated Submission Details", Toast.LENGTH_SHORT).show();
            goSub();
        } else
            Toast.makeText(editsubmission.this, " Not Updated Submission Details", Toast.LENGTH_SHORT).show();
    }

    public  void  goSub(){
        Intent intent2 = new Intent(editsubmission.this,submissions.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    public  void  goBack(View view){
        Intent intent2 = new Intent(editsubmission.this,submissions.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + Name  + " ?");
        builder.setMessage("Are you sure you want to delete " + Name  + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBHelper myDB = new DBHelper(editsubmission.this);
                Boolean checkupdatedata =   myDB.deleteSub(SID);
                if (checkupdatedata == true) {
                    Toast.makeText(editsubmission.this, " Successfully Deleted!", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(editsubmission.this, " Failed to Delete!", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();

    }

    public  void  openDelete(View view){
        confirmDialog();
    }

}