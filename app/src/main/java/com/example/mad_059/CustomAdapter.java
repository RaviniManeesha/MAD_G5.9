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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList sid, sName, Day,Time,Note,mName;

    CustomAdapter(Activity activity, Context context, ArrayList sid, ArrayList sName, ArrayList Day,ArrayList Time,ArrayList mName,ArrayList Note
                 ){
        this.activity = activity;
        this.context = context;
        this.sid = sid;
        this.sName = sName;
        this.Day = Day;
        this.Time = Time;
        this.Note= Note;
        this.mName= mName;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.sid_txt.setText(String.valueOf(sid.get(position)));
        holder.sName_txt.setText(String.valueOf(sName.get(position)));
        holder.Day_txt.setText(String.valueOf(Day.get(position)));
        holder.Time_txt.setText(String.valueOf(Time.get(position)));
        holder.Note_txt.setText(String.valueOf(Note.get(position)));
        holder.mName_txt.setText(String.valueOf(mName.get(position)));

        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, submission.class);
                intent.putExtra("sid", String.valueOf(sid.get(position)));
                intent.putExtra("sName", String.valueOf(sName.get(position)));
                intent.putExtra("Day", String.valueOf(Day.get(position)));
                intent.putExtra("Time", String.valueOf(Time.get(position)));
                intent.putExtra("Note", String.valueOf(Note.get(position)));
                intent.putExtra("mName", String.valueOf(mName.get(position)));

                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sid.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView sid_txt, sName_txt, Day_txt,Time_txt,Note_txt,mName_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sid_txt = itemView.findViewById(R.id.sid);
            sName_txt = itemView.findViewById(R.id.sName);
            Day_txt = itemView.findViewById(R.id.Day);
            Time_txt = itemView.findViewById(R.id.Time);
            Note_txt = itemView.findViewById(R.id.Note);
            mName_txt = itemView.findViewById(R.id.mName);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
