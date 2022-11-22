package com.example.pregnancy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Guide extends AppCompatActivity implements ActivityChanger{

    RecyclerView recyclerView;
    ArrayList<guideP> trimesters;
    guideAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.guideRecyclerView);
        recyclerView.setHasFixedSize(true);

        trimesters = new ArrayList<>();
        trimesters.add(new guideP("Trimester 1", "This is the first trimester since you got pregnant. Click to view details", R.drawable.trimester1));
        trimesters.add(new guideP("Trimester 2", "This is the Second trimester since you got pregnant. Click to view details", R.drawable.trimester2));
        trimesters.add(new guideP("Trimester 3", "This is the third trimester since you got pregnant. Click to view details", R.drawable.trimester3));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new guideAdapter(getApplicationContext(), trimesters, this);
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

    }

    @Override
    public void loadTrimester(String trimester_number) {
        Intent intent = new Intent(getApplicationContext(), TrimestersExplained.class);
        intent.putExtra("trimester_number", trimester_number);
        startActivity(intent);
    }
}