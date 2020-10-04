package com.example.unistudiac;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDetails extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6;
    Button btnUpdate, btnDelete;

    String no, name, code, cr, ca, fm, ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        e1 = findViewById(R.id.upmodN1);
        e2 = findViewById(R.id.upmodcod2);
        e3 = findViewById(R.id.upnocr2);
        e4 = findViewById(R.id.upcam2);
        e5 = findViewById(R.id.upfnm2);
        e6 = findViewById(R.id.upref2);

        setAndGetIntentData();

        //set action bar
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(name);
        }
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateDetails.this);
                name = e1.getText().toString();
                code =e2.getText().toString();
                cr =e3.getText().toString();
                ca =e4.getText().toString();
                fm =e5.getText().toString();
                ref =e6.getText().toString();
                myDB.updateDetails(name, no, code, cr, ca, fm, ref);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
    }
    void setAndGetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("code") && getIntent().hasExtra("cr") &&getIntent().hasExtra("ca") && getIntent().hasExtra("fm") && getIntent().hasExtra("ref"))
        {
            //Getting data from intent
            name = getIntent().getStringExtra("name");
            code = getIntent().getStringExtra("code");
            cr = getIntent().getStringExtra("cr");
            ca = getIntent().getStringExtra("ca");
            fm = getIntent().getStringExtra("fm");
            ref = getIntent().getStringExtra("ref");

            //Setting Intent Data

            e1.setText(name);
            e2.setText(code);
            e3.setText(cr);
            e4.setText(ca);
            e5.setText(fm);
            e6.setText(ref);

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
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateDetails.this);
                myDB.deleteRow(no);
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
}