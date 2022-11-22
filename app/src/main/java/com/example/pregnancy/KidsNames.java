package com.example.pregnancy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class KidsNames extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<baby_names_categoryP> categories;
    baby_names_category_adapter adapter;

    RecyclerView recyclerViewNames;
    ArrayList<child_nameP> names;
    child_name_adapter namesSAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_names);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.baby_names_category);

        categories = new ArrayList<>();
        categories.add(new baby_names_categoryP("Boy"));
        categories.add(new baby_names_categoryP("Girl"));
        categories.add(new baby_names_categoryP("Most Popular"));
        categories.add(new baby_names_categoryP("Celebrity"));
        categories.add(new baby_names_categoryP("Rich"));
        categories.add(new baby_names_categoryP("Famous"));

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new baby_names_category_adapter(getApplicationContext(), categories);
        recyclerView.setAdapter(adapter);

        recyclerViewNames = findViewById(R.id.children_names);
        recyclerViewNames.setHasFixedSize(true);

        names = new ArrayList<>();
        names.add(new child_nameP("Emmanuel", "This is a very good name. It actually means that God is within us. It has a jewish origin"));
        names.add(new child_nameP("Claude", "This is a European name, the meaning of 'Claude' is not quite clear. Its ancestry cannot be easily traced, but be sure it is a good name and very popular"));
        names.add(new child_nameP("Dominic", "This is a very good name. It actually means that God is within us. It has a jewish origin"));
        names.add(new child_nameP("Benson", "This is a European name, the meaning of 'Claude' is not quite clear. Its ancestry cannot be easily traced, but be sure it is a good name and very popular"));

        names.add(new child_nameP("Sharriff", "This is a very good name. It actually means that God is within us. It has a jewish origin"));
        names.add(new child_nameP("Oluoch", "This is a European name, the meaning of 'Claude' is not quite clear. Its ancestry cannot be easily traced, but be sure it is a good name and very popular"));

        names.add(new child_nameP("Sankoh", "This is a very good name. It actually means that God is within us. It has a jewish origin"));
        names.add(new child_nameP("Mwangi", "This is a European name, the meaning of 'Claude' is not quite clear. Its ancestry cannot be easily traced, but be sure it is a good name and very popular"));

        names.add(new child_nameP("Kiptanui", "This is a very good name. It actually means that God is within us. It has a jewish origin"));
        names.add(new child_nameP("Muthui", "This is a European name, the meaning of 'Claude' is not quite clear. Its ancestry cannot be easily traced, but be sure it is a good name and very popular"));

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager2.setOrientation(RecyclerView.VERTICAL);
        recyclerViewNames.setLayoutManager(linearLayoutManager2);

        namesSAdapter = new child_name_adapter(getApplicationContext(), names);
        recyclerViewNames.setAdapter(namesSAdapter);
    }
}