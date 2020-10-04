package com.example.unistudiac;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnDetails;
    private Button btnFinal;
    private Button btnGPA;
    //private Button button20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openAddModuleHome();
            }
        });

        btnDetails = (Button) findViewById(R.id.btnDetails);
        btnDetails.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                openABC();
            }


        });

        btnFinal = (Button) findViewById(R.id.btnFinal);
        btnFinal.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                openFinalMark();
            }


        });

        btnGPA = (Button) findViewById(R.id.btnGPA);
        btnGPA.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openGPACalculation();
            }
        });

    }

    private void openAddModuleHome() {

        Intent intent = new Intent(this, AddModulesHome.class);
        startActivity(intent);
    }

    private void openABC() {
        Intent intent = new Intent(this, ABC.class);
        startActivity(intent);
    }

    private void openFinalMark() {
        Intent intent = new Intent(this, FinalMark.class);
        startActivity(intent);
    }

    private void openGPACalculation() {
        Intent intent = new Intent(this, GPACalculation.class);
        startActivity(intent);
    }

}