package com.example.mad_059;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_059.Database.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updatepwd extends AppCompatActivity {
    TextView txtoldpwd,txtnewpwd,txtconpwd;
    Student std;
    Button btnupdate;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepwd);

        std = new Student();
        txtoldpwd =  findViewById(R.id.oldpwd);
        txtnewpwd =  findViewById(R.id.newpwd);
        txtconpwd =  findViewById(R.id.cpwd);

        btnupdate = findViewById(R.id.button7);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Student");
                updRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Std1"))
                        {

                            std.setPwd(txtnewpwd.getText().toString().trim());

                            dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child("Std1");
                            dbRef.setValue(std);

                            openProfile();
                            Toast.makeText(getApplicationContext(),"Update Password Successfully!",Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(getApplicationContext(),"Do not Success Update!!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Student").child("Std1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtoldpwd.setText(dataSnapshot.child("pwd").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public  void openProfile()
    {
        Intent intent1 = new Intent(updatepwd.this,profile.class);
        startActivity(intent1);
    }

}