package com.example.pregnancy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class guideAdapter extends RecyclerView.Adapter<guideAdapter.MyHolder> {
    Context context;
    ArrayList<guideP> trimesters;
    ActivityChanger activityChanger;

    public guideAdapter(Context context, ArrayList<guideP> trimesters, ActivityChanger activityChanger) {
        this.context = context;
        this.trimesters = trimesters;
        this.activityChanger = activityChanger;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_trimester_display, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.trimesterNumber.setText(trimesters.get(position).getTrimesterNumber());

        holder.trimesterImage.setImageResource(trimesters.get(position).getTrimesterImage());

        holder.trimesterText.setText(trimesters.get(position).getGetTrimesterText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityChanger.loadTrimester(trimesters.get(holder.getAdapterPosition()).getTrimesterNumber());
            }
        });
    }

    @Override
    public int getItemCount() {
        return trimesters.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView trimesterNumber, trimesterText;
        ImageView trimesterImage;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            trimesterNumber = itemView.findViewById(R.id.trimesterNumber);
            trimesterImage = itemView.findViewById(R.id.trimesterImage);
            trimesterText = itemView.findViewById(R.id.trimesterText);
        }
    }
}
