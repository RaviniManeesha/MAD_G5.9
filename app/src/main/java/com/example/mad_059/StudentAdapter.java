package com.example.mad_059;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList sub_id,subject,room,teacher,day,RegNo,time;



    StudentAdapter(Activity activity, Context context, ArrayList sub_id, ArrayList subject, ArrayList room,ArrayList time,
                   ArrayList teacher, ArrayList day,ArrayList RegNo ){
        this.activity = activity;
        this.context = context;
        this.sub_id = sub_id;
        this.subject = subject;
        this.room = room;
        this.teacher = teacher;
        this.day = day;
        this.RegNo = RegNo;
        this.time = time;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.monday_raw,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.sub_id.setText(String.valueOf(sub_id.get(position)));
        holder.subject.setText(String.valueOf(subject.get(position)));
        holder.room.setText(String.valueOf(room.get(position)));
        holder.teacher.setText(String.valueOf(teacher.get(position)));
        holder.day.setText(String.valueOf(day.get(position)));
        holder.txtRegNo.setText(String.valueOf(RegNo.get(position)));
        holder.txttime.setText(String.valueOf(time.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, updateattendance.class);
                intent.putExtra("id",String.valueOf(sub_id.get(position)));
                intent.putExtra("subject",String.valueOf(subject.get(position)));
                intent.putExtra("room",String.valueOf(room.get(position)));
                intent.putExtra("teacher",String.valueOf(teacher.get(position)));
                intent.putExtra("day",String.valueOf(day.get(position)));
                intent.putExtra("RegNo",String.valueOf(RegNo.get(position)));
                intent.putExtra("time",String.valueOf(time.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sub_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView sub_id,subject,room,teacher,day,txtRegNo,txttime;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sub_id =itemView.findViewById(R.id.sub_id_txt);
            subject =itemView.findViewById(R.id.subject);
            room =itemView.findViewById(R.id.room);
            teacher =itemView.findViewById(R.id.teacher);
            day = itemView.findViewById(R.id.day);
            txtRegNo = itemView.findViewById(R.id.reg);
            txttime  = itemView.findViewById(R.id.time);
            mainLayout = itemView.findViewById(R.id.moduleLayout);

        }
    }
}
