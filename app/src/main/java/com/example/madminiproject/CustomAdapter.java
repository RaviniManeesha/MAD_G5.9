package com.example.madminiproject;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList ID,txtTitleIn,txtDateBIn,txtDateEIn;


    CustomAdapter(Activity activity, Context context, ArrayList ID, ArrayList txtTitleIn, ArrayList txtDateBIn,ArrayList txtDateEIn){
        this.activity = activity;
        this.context = context;
        this.ID = ID;
        this.txtTitleIn = txtTitleIn;
        this.txtDateBIn = txtDateBIn;
        this.txtDateEIn = txtDateEIn;


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.ID_txt.setText(String.valueOf(ID.get(position)));
        holder.Title_txt.setText(String.valueOf(txtTitleIn.get(position)));
        holder.dateB_txt.setText(String.valueOf(txtDateBIn.get(position)));
        holder.dateE_txt.setText(String.valueOf(txtDateEIn.get(position)));

        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, viewBookList.class);
                intent.putExtra("Id", String.valueOf(ID.get(position)));
                intent.putExtra("title", String.valueOf(txtTitleIn.get(position)));
                intent.putExtra("dateBorrow", String.valueOf(txtDateBIn.get(position)));
                intent.putExtra("dateExp", String.valueOf(txtDateEIn.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ID_txt, Title_txt, dateB_txt,dateE_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ID_txt = itemView.findViewById(R.id.ID);
            Title_txt = itemView.findViewById(R.id.txtTitleIn);
            dateB_txt = itemView.findViewById(R.id.txtDateBIn);
            dateE_txt = itemView.findViewById(R.id.txtDateEIn);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }

    }

}




