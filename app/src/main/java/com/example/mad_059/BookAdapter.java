package com.example.mad_059;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter  extends RecyclerView.Adapter<BookAdapter.MyViewHolder>{

    private Context context;
    private Activity activity;
    private ArrayList ID,txtTitleIn,txtDateEIn,txtDateBIn,txtRegNo;

    BookAdapter (Activity activity, Context context, ArrayList ID, ArrayList txtTitleIn, ArrayList txtDateEIn, ArrayList txtDateBIn,ArrayList txtRegNo){
        this.activity = activity;
        this.context = context;
        this.ID = ID;
        this.txtTitleIn = txtTitleIn;
        this.txtDateEIn = txtDateEIn;
        this.txtDateBIn = txtDateBIn;
        this.txtRegNo = txtRegNo;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.bookrow, parent, false);
        return new MyViewHolder(view);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.bid_txt.setText(String.valueOf(ID.get(position)));
        holder.title_txt.setText(String.valueOf(txtTitleIn.get(position)));
        holder.Edate_txt.setText(String.valueOf(txtDateEIn.get(position)));
        holder.Bdate_txt.setText(String.valueOf(txtDateBIn.get(position)));
        holder.Reg_txt.setText(String.valueOf(txtRegNo.get(position)));

        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, updatebook.class);
                intent.putExtra("ID", String.valueOf(ID.get(position)));
                intent.putExtra("title", String.valueOf(txtTitleIn.get(position)));
                intent.putExtra("edate", String.valueOf(txtDateEIn.get(position)));
                intent.putExtra("bdate", String.valueOf(txtDateBIn.get(position)));
                intent.putExtra("RegNo", String.valueOf(txtRegNo.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bid_txt, title_txt, Edate_txt,Bdate_txt,Reg_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bid_txt = itemView.findViewById(R.id.ID);
            title_txt = itemView.findViewById(R.id.txtTitleIn);
            Edate_txt = itemView.findViewById(R.id.txtDateEIn);
            Bdate_txt = itemView.findViewById(R.id.txtDateBIn);
            Reg_txt = itemView.findViewById(R.id.reg);
            mainLayout = itemView.findViewById(R.id.bookLayout);

        }

    }

}
