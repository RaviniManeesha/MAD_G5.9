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

public class MDetailsAdapter extends RecyclerView.Adapter<MDetailsAdapter.newViewHolder> {

        private Context context;
        Activity activity;
        private ArrayList modID, modName, modCode, noOfCredits, caMarks, fMarks, ref,RegNo;
        int position;

        MDetailsAdapter(Activity activity, Context context,  ArrayList modID, ArrayList modName, ArrayList modCode, ArrayList noOfCredits, ArrayList caMarks, ArrayList fMarks, ArrayList ref,ArrayList RegNo){
            this.activity = activity;
            this.context = context;
            this.modID = modID;
            this.modName = modName;
            this.modCode = modCode;
            this.noOfCredits = noOfCredits;
            this.caMarks = caMarks;
            this.fMarks = fMarks;
            this.ref = ref;
            this.RegNo = RegNo;
        }

    @NonNull
        @Override
        public MDetailsAdapter.newViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.detailsrow, parent, false);
            return new MDetailsAdapter.newViewHolder(view);
        }



    @Override
        public void onBindViewHolder(@NonNull MDetailsAdapter.newViewHolder holder, final int position) {

            this.position= position;

            holder.modID.setText(String.valueOf(modID.get(position)));
            holder.modName.setText(String.valueOf(modName.get(position)));
            holder.modCode.setText(String.valueOf(modCode.get(position)));
            holder.noOfCredits.setText(String.valueOf(noOfCredits.get(position)));
            holder.caMarks.setText(String.valueOf(caMarks.get(position)));
            holder.fMarks.setText(String.valueOf(fMarks.get(position)));
            holder.ref.setText(String.valueOf(ref.get(position)));
            holder.RegNo.setText(String.valueOf(RegNo.get(position)));
            holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent (context, UpdateDetails.class);
                    intent.putExtra("no", String.valueOf(modID.get(position)));
                    intent.putExtra("name", String.valueOf(modName.get(position)));
                    intent.putExtra("code", String.valueOf(modCode.get(position)));
                    intent.putExtra("cr", String.valueOf(noOfCredits.get(position)));
                    intent.putExtra("ca", String.valueOf(caMarks.get(position)));
                    intent.putExtra("fm", String.valueOf(fMarks.get(position)));
                    intent.putExtra("ref", String.valueOf(ref.get(position)));
                    intent.putExtra("RegNo", String.valueOf(RegNo.get(position)));
                    activity.startActivityForResult(intent, 1);
                }
            });


        }

        @Override
        public int getItemCount() {return modID.size();}

        public class newViewHolder extends RecyclerView.ViewHolder {

            TextView modID, modName, modCode, noOfCredits, caMarks, fMarks, ref,RegNo;
            LinearLayout mainLayout;

            public newViewHolder(@NonNull View itemView) {
                super(itemView);
                modID = itemView.findViewById(R.id.module_id2);
                modName = itemView.findViewById(R.id.modName2);
                modCode = itemView.findViewById(R.id.modCode2);
                noOfCredits = itemView.findViewById(R.id.modCr2);
                caMarks = itemView.findViewById(R.id.modCa2);
                fMarks = itemView.findViewById(R.id.modFn2);
                ref = itemView.findViewById(R.id.modRef2);
                RegNo = itemView.findViewById(R.id.reg);
                mainLayout = itemView.findViewById(R.id.mainLayout1);
            }
        }
}
