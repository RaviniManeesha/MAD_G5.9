package com.example.mad_059;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class viewprofile extends AppCompatActivity {

    private Button button3;
    TextView textView2,txtregno,txtpwd,txtname,txtemail,txtphone,txtdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        txtregno =  findViewById(R.id.reegno);
        txtname =  findViewById(R.id.name);
        txtpwd =  findViewById(R.id.password);
        txtphone =  findViewById(R.id.phone);
        txtdate =  findViewById(R.id.date);
        txtemail =  findViewById(R.id.email);

        button3 =(Button) findViewById(R.id.button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEdit();
            }
        });

        textView2 =  findViewById(R.id.textView19);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(viewprofile.this,profile.class);
                startActivity(intent1);


            }
        });

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Student").child("Std1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtregno.setText(dataSnapshot.child("regNo").getValue().toString());
                txtname.setText(dataSnapshot.child("stName").getValue().toString());
                txtpwd.setText(dataSnapshot.child("pwd").getValue().toString());
                txtphone.setText(dataSnapshot.child("phone").getValue().toString());
                txtemail.setText(dataSnapshot.child("email").getValue().toString());
                txtdate.setText(dataSnapshot.child("date").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void openEdit(){

        Intent intent3 = new Intent(this,editprofile.class);
        startActivity(intent3);
    }
}