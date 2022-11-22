package com.example.pregnancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class baby_names_category_adapter extends RecyclerView.Adapter<baby_names_category_adapter.MyHolder> {

    Context context;
    ArrayList<baby_names_categoryP> categories;

    public baby_names_category_adapter(Context context, ArrayList<baby_names_categoryP> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.baby_name_category, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.category_btn.setText(categories.get(position).getCategory_name());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ;
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        Button category_btn;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            category_btn = itemView.findViewById(R.id.baby_name_category_button);
        }
    }
}
