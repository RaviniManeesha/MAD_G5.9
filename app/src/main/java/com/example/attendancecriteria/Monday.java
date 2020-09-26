package com.example.attendancecriteria;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Monday extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton Add_button;
    ImageView empty_image;
    TextView no_data;

    MyDatabaseHelper myDB;
    ArrayList<String> sub_id, subject, room, teacher,day;
    StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);



        recyclerView = findViewById(R.id.recyclerView);
        Add_button = findViewById(R.id.Add_button);
        empty_image = findViewById(R.id.empty);
        no_data = findViewById(R.id.nodata);





        Add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Monday.this, Add_Form.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(Monday.this);
        sub_id = new ArrayList<>();
        subject = new ArrayList<>();
        room = new ArrayList<>();
        teacher = new ArrayList<>();
        day = new ArrayList<>();


        storeDataArrays();

        studentAdapter = new StudentAdapter(Monday.this, this, sub_id, subject, room, teacher,day);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Monday.this));
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }


    void storeDataArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
           empty_image.setVisibility(View.VISIBLE);
           no_data.setVisibility(View.VISIBLE);


        } else {
            while (cursor.moveToNext()) {
                sub_id.add(cursor.getString(0));
                subject.add(cursor.getString(1));
                room.add(cursor.getString(2));
                teacher.add(cursor.getString(3));
                day.add(cursor.getString(4));
            }
            empty_image.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);

    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All");
        builder.setMessage(" Are you sure you want to delete all data ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Monday.this);
                myDB.deleteAllData();
                Intent intent = new Intent(Monday.this, Monday.class);
                startActivity(intent);
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
}