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

public class editprofile extends AppCompatActivity {

    Button btndone;
    TextView textView4,txtregno,txtname,txtemail,txtphone,txtdate,txteditpwd,txtPwd,txtRePwd ;

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);



        txtregno =  findViewById(R.id.regno);
        txtname =  findViewById(R.id.stname);
        txtphone =  findViewById(R.id.phone);
        txtdate =  findViewById(R.id.date);
        txtemail =  findViewById(R.id.email);

        //view data
        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Student").child("Std1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtregno.setText(dataSnapshot.child("regNo").getValue().toString());
                txtname.setText(dataSnapshot.child("stName").getValue().toString());
                txtphone.setText(dataSnapshot.child("phone").getValue().toString());
                txtemail.setText(dataSnapshot.child("email").getValue().toString());
                txtdate.setText(dataSnapshot.child("date").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //update data
        btndone = findViewById(R.id.btndone2);
        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Student");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.hasChild("Std1"))
                        {
                            try {
                              



                                clearControls();


                                Toast.makeText(getApplicationContext(),"Update Successfully!",Toast.LENGTH_SHORT).show();

                            }catch (NumberFormatException e)
                            {
                                Toast.makeText(getApplicationContext(),"Error!!",Toast.LENGTH_SHORT).show();
                                openDone();
                            }
                        }else
                        {
                            Toast.makeText(getApplicationContext(),"No Source to Update!!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        textView4 = (TextView) findViewById(R.id.textView22);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(editprofile.this,viewprofile.class);
                startActivity(intent1);


            }
        });



    }

    public void openDone(){

        Intent intent4 = new Intent(this,viewprofile.class);
        startActivity(intent4);
    }

    private void clearControls(){

        txtname.setText("");
        txtphone.setText("");
        txtemail.setText("");
        txtdate.setText("");
        txtregno.setText("");
        txtPwd.setText("");
        txtRePwd.setText("");

    }
}