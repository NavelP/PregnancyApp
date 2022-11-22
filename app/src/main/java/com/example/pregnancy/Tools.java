package com.example.pregnancy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Tools extends AppCompatActivity implements ActivityChanger{

    RecyclerView recyclerView;
    toolsAdapter adapter;
    ArrayList<toolsP> tools;
    public static TextToSpeech tts;

    ImageView toolsBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.toolsRecycle);

        toolsBack = findViewById(R.id.toolsBack);

        toolsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        tools = new ArrayList<>();

        tools.add(new toolsP(R.drawable.userguide, "Guide", "#ff9900"));
        tools.add(new toolsP(R.drawable.notes, "Notes", "#ffcc00"));
        tools.add(new toolsP(R.drawable.appointment, "Appointments", "#33ff99"));
        tools.add(new toolsP(R.drawable.questions, "My Questions", "#ff0000"));
        tools.add(new toolsP(R.drawable.childer_names, "Kids Names", "#bfff00"));
        tools.add(new toolsP(R.drawable.meals, "Today's Meal", "#ff3399"));

        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new toolsAdapter(getApplicationContext(), tools, this);
        recyclerView.setAdapter(adapter);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i == TextToSpeech.SUCCESS){
                    int results = tts.setLanguage(Locale.ENGLISH);

                    if(results == TextToSpeech.LANG_MISSING_DATA || results == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(getApplicationContext(), "Not supported! A", Toast.LENGTH_SHORT).show();

                        //holder.articulate.setEnabled(false);
                    }else{
                        //holder.articulate.setEnabled(true);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Not supported!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void toolsActivityChanger(int position) {
        if(tools.get(position).getTools_name().equals("Appointments")){
            startActivity(new Intent(getApplicationContext(), BookAppointment.class));
        }else if(tools.get(position).getTools_name().equals("Notes")){
            startActivity(new Intent(getApplicationContext(), Notes.class));
        }else if(tools.get(position).getTools_name().equals("Kids Names")){
            startActivity(new Intent(getApplicationContext(), KidsNames.class));
        }else if(tools.get(position).getTools_name().equals("Guide")){
            startActivity(new Intent(getApplicationContext(), Guide.class));
        }else if(tools.get(position).getTools_name().equals("Today's Meal")){
            startActivity(new Intent(getApplicationContext(), Meals.class));
        }else if (tools.get(position).getTools_name().equals("My Questions")){
            startActivity(new Intent(getApplicationContext(), Questions.class));
        }
    }

    @Override
    public void doctorsActivityChanger(int position) {

    }

    @Override
    public void readNotes(String noteTitle, String noteDate, String noteText) {

    }

    @Override
    public void loadTrimester(String trimester_number) {

    }
}