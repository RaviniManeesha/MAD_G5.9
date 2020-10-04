package com.example.unistudiac;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddDetailsHome extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton addDetailsBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module_home);

        recyclerView = findViewById(R.id.recyclerView1);
        addDetailsBtn = findViewById(R.id.addDetailsBtn);
        addDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddDetailsHome.this,ABC.class);
                startActivity(intent);
            }
        });

            }





}