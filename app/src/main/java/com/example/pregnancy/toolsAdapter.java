package com.example.pregnancy;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class toolsAdapter extends RecyclerView.Adapter<toolsAdapter.MyHolder> {

    Context context;
    ArrayList<toolsP> tools;
    ActivityChanger activityChanger;

    public toolsAdapter(Context context, ArrayList<toolsP> tools, ActivityChanger activityChanger) {
        this.context = context;
        this.tools = tools;
        this.activityChanger = activityChanger;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_tool_display, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //holder.cardView.setBackgroundColor(Color.parseColor(tools.get(position).getBackground()));
        holder.toolName.setText(tools.get(position).getTools_name());
        holder.tool_image.setImageResource(tools.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityChanger.toolsActivityChanger(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return tools.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView toolName;
        ImageView tool_image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.tools_background);
            tool_image = itemView.findViewById(R.id.tool_image);
            toolName = itemView.findViewById(R.id.tool_name);
        }
    }
}
