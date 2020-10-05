package com.example.mad_059;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_059.Database.DBHelper;

public class updatemodule extends AppCompatActivity {

    EditText module_id, module_name, module_no,txtRegNo;
    Button updateButton, deleteButton;
    String id, name, no,RegNo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatemodule);

        module_name = findViewById(R.id.title_input2);
        module_no = findViewById(R.id.input_no2);
        txtRegNo = findViewById(R.id.id);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        getAndSetIntentData();

        //set action bar
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(name);
        }


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               DBHelper myDB = new DBHelper(updatemodule.this);
                name = module_name.getText().toString();
                no =module_no.getText().toString();

                Boolean checkupdatedata =  myDB.updateData4(id, name,no);
                if (checkupdatedata == true) {

                    Toast.makeText(updatemodule.this, " Successfully Updated!", Toast.LENGTH_SHORT).show();
                    goList();
                } else
                    Toast.makeText(updatemodule.this, " Failed to Update!", Toast.LENGTH_SHORT).show();

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });




    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("no"))
        {
            //Getting data from intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            no = getIntent().getStringExtra("no");
            RegNo = getIntent().getStringExtra("RegNo");

            //Setting Intent Data

            module_name.setText(name);
            module_no.setText(no);
            txtRegNo.setText(RegNo);

        }else{
            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBHelper myDB = new DBHelper(updatemodule.this);
                Boolean checkupdatedata =   myDB.deleteOneRow4(id);
                if (checkupdatedata == true) {
                    Toast.makeText(updatemodule.this, " Successfully Deleted!", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(updatemodule.this, " Failed to Delete!", Toast.LENGTH_SHORT).show();

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
    public  void  goList(){
        Intent intent2 = new Intent(updatemodule.this,modulelist.class);
        intent2.putExtra("RegNo", txtRegNo.getText().toString());
        startActivity(intent2);
    }

}
