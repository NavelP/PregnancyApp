package com.example.pregnancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class timeSlotsAdapter extends RecyclerView.Adapter<timeSlotsAdapter.MyHolder> {
    Context context;
    ArrayList<timeSlotsP> timeSlots;

    public timeSlotsAdapter(Context context, ArrayList<timeSlotsP> timeSlots) {
        this.context = context;
        this.timeSlots = timeSlots;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_time_slot, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.timeSlot.setText(timeSlots.get(position).getTimeslot());
    }

    @Override
    public int getItemCount() {
        return timeSlots.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView timeSlot;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            timeSlot = itemView.findViewById(R.id.single_time_slot);
        }
    }
}
