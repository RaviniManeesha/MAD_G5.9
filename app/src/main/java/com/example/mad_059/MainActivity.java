package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }

public void openRegister( View view){

        Intent intent1 = new Intent(this, register1.class);
        startActivity(intent1);
        }

        public void openLogin(View view){


                Intent intent2 = new Intent(this,login.class);
                startActivity(intent2);


        }
        }



