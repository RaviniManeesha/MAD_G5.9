package com.example.mad_059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mad_059.R;
import com.example.mad_059.register1;

public class MainActivity extends AppCompatActivity {

private Button button;
private Button button2;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =(Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        openRegister();
                }
        });

        button =(Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        openLogin();
                }
        });
        }

public void openRegister(){

        Intent intent = new Intent(this, register1.class);
        startActivity(intent);
        }

        public void openLogin(){


                Intent intent2 = new Intent(this,login.class);
                startActivity(intent2);


        }
        }



