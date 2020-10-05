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

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.MyViewHolder>  {

    private Context context;
    Activity activity;
    private ArrayList module_id, module_name, module_no,RegNo;

    //int position;

   ModuleAdapter(Activity activity, Context context, ArrayList module_id, ArrayList module_name, ArrayList module_no,ArrayList RegNo){
        this.activity = activity;
        this.context = context;
        this.module_id = module_id;
        this.module_name = module_name;
        this.module_no = module_no;
        this.RegNo = RegNo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.modulerow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        //this.position= position;

        holder.module_id.setText(String.valueOf(module_id.get(position)));
        holder.modName.setText(String.valueOf(module_name.get(position)));
        holder.modNo.setText(String.valueOf(module_no.get(position)));
        holder.txtRegNo.setText(String.valueOf(RegNo.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, updatemodule.class);
                intent.putExtra("id", String.valueOf(module_id.get(position)));
                intent.putExtra("name", String.valueOf(module_name.get(position)));
                intent.putExtra("no", String.valueOf(module_no.get(position)));
                intent.putExtra("RegNo", String.valueOf(RegNo.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return module_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView module_id, modName, modNo,txtRegNo;
        LinearLayout mainLayout;

        public MyViewHolder(View itemview) {
            super(itemview);

           module_id = itemview.findViewById(R.id.module_id);
           modName = itemview.findViewById(R.id.modName);
           modNo = itemview.findViewById(R.id.modNo);
           txtRegNo = itemview.findViewById(R.id.modreg);
           mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
