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

public class editmodule extends AppCompatActivity {

    TextView txtmCode,txtmName;
    DBHelper DB;
    String  Name,Code;
    Button btnEdit;
    Integer MID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editmodule);

        txtmCode = findViewById(R.id.mCode);
        txtmName = findViewById(R.id.mName);
        btnEdit = findViewById(R.id.btnMdone);

        DB = new DBHelper(this);
        Cursor cursor = DB.getmData();
        if(cursor.getCount() == 0){

            Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

        }else{

            while(cursor.moveToNext()){
                MID = Integer.valueOf(cursor.getString(0));
                Name =  cursor.getString(1);
                Code =  cursor.getString(2);

            }
        }

        txtmName.setText(Name);
        txtmCode.setText(Code);

        //update data
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = txtmName.getText().toString();
                String Code = txtmCode.getText().toString();

                Boolean checkupdatedata = DB.UpdateModule(MID, Name,Code);
                if (checkupdatedata == true) {
                    Toast.makeText(editmodule.this, " Updated Submission Details", Toast.LENGTH_SHORT).show();
                        openModule();
                } else
                    Toast.makeText(editmodule.this, " Not Updated Submission Details", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public  void  openModule(){
        Intent intent1 = new Intent(editmodule.this,module.class);
        startActivity(intent1);
    }


    public void goModule(View view){
        Intent intent2 = new Intent(editmodule.this,module.class);
        startActivity(intent2);
    }
}