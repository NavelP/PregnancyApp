package com.example.pregnancy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class Questions extends AppCompatActivity {

    ImageView imageView;
    QuestionsTabadapter adapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        getSupportActionBar().hide();

        imageView = findViewById(R.id.toolsQuestionsBack);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Tools.class));
            }
        });

        adapter = new QuestionsTabadapter(getSupportFragmentManager());

        tabLayout = findViewById(R.id.QuestionsTabLayout);
        viewPager = findViewById(R.id.QuestionsPageViewer);

        adapter.add();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LinearLayout tablay = (LinearLayout)((ViewGroup)tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView text = (TextView)tablay.getChildAt(1);
                text.setTypeface(null, Typeface.BOLD);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                LinearLayout tablay = (LinearLayout)((ViewGroup)tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView text = (TextView)tablay.getChildAt(1);
                text.setTypeface(null, Typeface.NORMAL);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}