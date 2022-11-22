package com.example.pregnancy;

import static android.view.View.GONE;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Notes extends AppCompatActivity implements ActivityChanger{

    RecyclerView recyclerView;
    ArrayList<notesP> notes;
    notesAdapter adapter;
    AlertDialog.Builder builder;
    AlertDialog notesDialog;

    CardView add_note;
    Button saveButton;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        getSupportActionBar().hide();
        fab = findViewById(R.id.addNote);

        builder = new AlertDialog.Builder(Notes.this);
        View view = getLayoutInflater().inflate(R.layout.add_notes, null);

        saveButton = view.findViewById(R.id.added_note_save);

        builder.setView(view);

        notesDialog = builder.create();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesDialog.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesDialog.dismiss();
            }
        });

        recyclerView = findViewById(R.id.myNotes);

        notes = new ArrayList<>();
        notes.add(new notesP("Pregnancy exercises", "Object-Oriented Analysis and Design has over the years, become a vast field encompassing such\n" +
                "diverse topics as design process and principles, documentation tools, refactoring, and design and\n" +
                "architecture patterns. Object-Oriented Analysis and Design can offer an approach that facilitates\n" +
                "logical, rapid and thorough methods for creating new systems responsive to a changing business\n" +
                "language. Object-Oriented techniques work well in situations in which complicated information\n" +
                "systems are undergoing continuous maintenance, adaptation and redesign. The course\n" +
                "comprehensively explores Object-Oriented Analysis and Design with a reflection to Object-\n" +
                "Oriented Programming approach.", "31-04-2022"));

        notes.add(new notesP("Exercise Duration", "Object-Oriented Analysis and Design has over the years, become a vast field encompassing such\n" +
                "diverse topics as design process and principles, documentation tools, refactoring, and design and\n" +
                "architecture patterns. Object-Oriented Analysis and Design can offer an approach that facilitates\n" +
                "logical, rapid and thorough methods for creating new systems responsive to a changing business\n" +
                "Oriented Programming approach.", "01-08-2022"));

        notes.add(new notesP("Importance of Exercise", "Object-Oriented Analysis and Design has over the years, become a vast field encompassing such\n" +
                "diverse topics as design process and principles, documentation tools, refactoring, and design and\n" +
                "architecture patterns. Object-Oriented Analysis and Design can offer an approach that facilitates\n" +
                "logical, rapid and thorough methods for creating new systems responsive to a changing business\n" +
                "language. Object-Oriented techniques work well in situations in which complicated information\n" +
                "systems are undergoing continuous maintenance, adaptation and redesign. The course\n" +
                "comprehensively explores Object-Oriented Analysis and Design with a reflection to Object-\n" +
                "Oriented Programming approach.", "23-04-2022"));

        notes.add(new notesP("Pregnancy exercises", "Object-Oriented Analysis and Design has over the years, become a vast field encompassing such\n" +
                "diverse topics as design process and principles, documentation tools, refactoring, and design and\n" +
                "architecture patterns. Object-Oriented Analysis and Design can offer an approach that facilitates\n" +
                "logical, rapid and thorough methods for creating new systems responsive to a changing business\n" +
                "language. Object-Oriented techniques work well in situations in which complicated information\n" +
                "systems are undergoing continuous maintenance, adaptation and redesign. The course\n" +
                "comprehensively explores Object-Oriented Analysis and Design with a reflection to Object-\n" +
                "Oriented Programming approach.", "22-04-2022"));

        notes.add(new notesP("Dangers of bad diet", "Object-Oriented Analysis and Design has over the years, become a vast field encompassing such\n" +
                "diverse topics as design process and principles, documentation tools, refactoring, and design and\n" +
                "architecture patterns. Object-Oriented Analysis and Design can offer an approach that facilitates\n" +
                "logical, rapid and thorough methods for creating new systems responsive to a changing business\n" +
                "language. Object-Oriented techniques work well in situations in which complicated information\n" +
                "systems are undergoing continuous maintenance, adaptation and redesign. The course\n" +
                "comprehensively explores Object-Oriented Analysis and Design with a reflection to Object-\n" +
                "Oriented Programming approach.", "03-04-2022"));

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new notesAdapter(getApplicationContext(), notes, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void toolsActivityChanger(int position) {

    }

    @Override
    public void doctorsActivityChanger(int position) {

    }

    @Override
    public void readNotes(String noteTitle, String noteDate, String noteText) {
        View view = getLayoutInflater().inflate(R.layout.single_note_display, null);
        TextView notesTitle, notesDate, notesText;
        EditText notesTextEdit;

        Button dismissBox, saveNotes;
        ImageButton deleteNote, editNote;

        notesTitle = view.findViewById(R.id.noteTitle);
        notesDate = view.findViewById(R.id.noteDate);
        notesText = view.findViewById(R.id.noteText);

        notesTextEdit = view.findViewById(R.id.noteTextEdit);

        deleteNote = view.findViewById(R.id.deleteNote);
        editNote = view.findViewById(R.id.editNote);
        dismissBox = view.findViewById(R.id.dismissNote);
        saveNotes = view.findViewById(R.id.saveNote);

        notesTitle.setText(noteTitle);
        notesDate.setText(noteDate);
        notesText.setText(noteText);

        notesText.setTextSize(20f);

        deleteNote.setVisibility(View.VISIBLE);
        editNote.setVisibility(View.VISIBLE);
        dismissBox.setVisibility(View.VISIBLE);

        builder = new AlertDialog.Builder(Notes.this);
        builder.setView(view);

        notesDialog = builder.create();

        dismissBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesDialog.dismiss();
            }
        });

        editNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesTextEdit.setVisibility(View.VISIBLE);
                notesTextEdit.setText(noteText);

                notesText.setVisibility(GONE);
                saveNotes.setVisibility(View.VISIBLE);

                dismissBox.setVisibility(GONE);
                deleteNote.setVisibility(GONE);
                editNote.setVisibility(GONE);

            }
        });

        saveNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesTextEdit.setVisibility(GONE);
                notesText.setVisibility(View.VISIBLE);

                dismissBox.setVisibility(View.VISIBLE);
                deleteNote.setVisibility(View.VISIBLE);
                editNote.setVisibility(View.VISIBLE);

                saveNotes.setVisibility(GONE);
            }
        });

        notesDialog.show();
    }

    @Override
    public void loadTrimester(String trimester_number) {

    }
}