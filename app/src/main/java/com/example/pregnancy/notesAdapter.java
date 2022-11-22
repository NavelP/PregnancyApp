package com.example.pregnancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class notesAdapter extends RecyclerView.Adapter<notesAdapter.MyHolder> {
    Context context;
    ArrayList<notesP> notes;
    ActivityChanger readNote;

    public notesAdapter(Context context, ArrayList<notesP> notes, ActivityChanger readNote) {
        this.context = context;
        this.notes = notes;
        this.readNote = readNote;
    }

    @NonNull
    @Override
    public notesAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_note_display, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull notesAdapter.MyHolder holder, int position) {
        holder.noteText.setMaxLines(6);
        holder.noteText.setMinLines(1);
        holder.noteText.setText(notes.get(position).getNotesText());
        holder.noteDate.setText(notes.get(position).getNotesDate());
        holder.noteTitle.setText(notes.get(position).getNotesTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readNote.readNotes(notes.get(holder.getAdapterPosition()).getNotesTitle(),
                        notes.get(holder.getAdapterPosition()).getNotesDate(), notes.get(holder.getAdapterPosition()).getNotesText());
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView noteTitle, noteDate, noteText;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            noteTitle = itemView.findViewById(R.id.noteTitle);
            noteDate = itemView.findViewById(R.id.noteDate);
            noteText = itemView.findViewById(R.id.noteText);
        }
    }
}
