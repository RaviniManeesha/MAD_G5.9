package com.example.mad_059;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mad_059.Database.DBHelper;
import com.example.mad_059.Database.Module;


public class addmodule extends AppCompatActivity {

    TextView txtmName,txtmCode,txtRegNo;
    Button btnDone;
    DBHelper DB;
    String  RegNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmodule);

        txtmName = findViewById(R.id.mName);
        txtmCode = findViewById(R.id.mCode);
        txtRegNo = findViewById(R.id.RegNo);

        DB = new DBHelper(this);
        btnDone = findViewById(R.id.btnDone);
        //Get registration No

        Cursor cursor = DB.getData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data in Table",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                RegNo = cursor.getString(1);
            }
        }

        txtRegNo.setText(RegNo);


        //insert data
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(txtmName.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Module Name", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(txtmCode.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please enter the Module Code", Toast.LENGTH_SHORT).show();
                }else {

                    String mName = txtmName.getText().toString();
                    String mCode = txtmCode.getText().toString();
                    String RegNO = txtRegNo.getText().toString();


                    Boolean checkinsertdata2 = DB.insertModule(mName, mCode, RegNO);
                    if (checkinsertdata2 == true) {
                        Toast.makeText(addmodule.this, "Add New Module Successfully!", Toast.LENGTH_SHORT).show();
                        goSubmissionDone();

                    } else
                        Toast.makeText(addmodule.this, "Adding Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public  void goSubmissionDone(){
        Intent intent2 = new Intent(this,viewsubmissions.class);
        startActivity(intent2);
    }

}