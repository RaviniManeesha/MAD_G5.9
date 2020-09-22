package com.example.mad_059;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    TextView txtstName,txtrno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtrno = findViewById(R.id.Rnumber);
        txtstName = findViewById(R.id.stName);

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Student").child("Std1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren())
                {
                    txtrno.setText(dataSnapshot.child("regNo").getValue().toString());
                    txtstName.setText(dataSnapshot.child("stName").getValue().toString());
                }
                else{
                    Toast.makeText(getApplicationContext(),"No data in DB",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        txtstName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(profile.this,viewprofile.class);
                startActivity(intent2);

            }
        });

        Button button5 =  findViewById(R.id.button10);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogout();
            }
        });

        Button button6 =  findViewById(R.id.button3);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubmissions();
            }
        });

        Button button7 =  findViewById(R.id.button9);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInformation();
            }
        });
    }

    public void openLogout(){

        Intent intent8 = new Intent(this,login.class);
        startActivity(intent8);


    }
    public void openSubmissions(){

        Intent intent6 = new Intent(this,viewsubmissions.class);
        startActivity(intent6);


    }

    public void openInformation(){

        Intent intent7 = new Intent(this,information.class);
        startActivity(intent7);


    }
}