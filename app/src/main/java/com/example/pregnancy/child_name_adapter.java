package com.example.pregnancy;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class child_name_adapter extends RecyclerView.Adapter<child_name_adapter.MyHolder> {

    Context context;
    ArrayList<child_nameP> names;

    public child_name_adapter(Context context, ArrayList<child_nameP> names) {
        this.context = context;
        this.names = names;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_name, parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.articulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.tts.speak(holder.name.getText().toString() + ". "+holder.description.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.favorite.setImageResource(R.drawable.ic_baseline_star_24);
            }
        });

        holder.expand_collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.card.getVisibility() == View.VISIBLE){
                    holder.card.setVisibility(View.GONE);
                    holder.expand_collapse.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24);
                }else{
                    holder.card.setVisibility(View.VISIBLE);
                    holder.expand_collapse.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }
        });

        holder.name.setText(names.get(position).getName());

        holder.description.setText(names.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView expand_collapse, favorite, articulate;
        TextView name, description;
        CardView card;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            expand_collapse = itemView.findViewById(R.id.child_name_expand_icon);
            favorite = itemView.findViewById(R.id.favorite);
            articulate = itemView.findViewById(R.id.articulate);

            name = itemView.findViewById(R.id.child_name);
            description = itemView.findViewById(R.id.exact_description_text);

            card = itemView.findViewById(R.id.name_description);
        }
    }
}
