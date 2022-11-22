package com.example.pregnancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class askedQuestionsAdapter extends RecyclerView.Adapter<askedQuestionsAdapter.MyHolder> {
    ArrayList<askedQuestionsP> questions;
    Context context;

    public askedQuestionsAdapter(ArrayList<askedQuestionsP> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_question_display, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.question_text.setText(questions.get(position).getQuestion());

        holder.answers_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ;
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView question_text;
        Button answers_button;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            question_text = itemView.findViewById(R.id.asked_question_text);

            answers_button = itemView.findViewById(R.id.view_answers);
        }
    }
}
