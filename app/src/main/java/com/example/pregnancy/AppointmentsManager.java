package com.example.pregnancy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class AppointmentsManager extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    AppointmentsAdapter adapter;
    String source;

    ImageView doctorsBackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments_manager);

        getSupportActionBar().hide();

        Bundle bundle = getIntent().getExtras();

        doctorsBackManager = findViewById(R.id.doctorsBackManager);

        doctorsBackManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BookAppointment.class));
            }
        });

        assert bundle != null;

        source = bundle.getString("source");

        if(source.equals("view")){
            adapter = new AppointmentsAdapter(getSupportFragmentManager(), "view");
        }else if(source.equals("book")){
            int doctors_image = bundle.getInt("doctors_profile");

            String doctors_name = bundle.getString("doctors_name");

            String doctors_department = bundle.getString("doctors_department");

            String doctors_specialization = bundle.getString("doctors_specialization");

            adapter = new AppointmentsAdapter(getSupportFragmentManager(), "book", doctors_name, doctors_specialization, doctors_department, doctors_image);
        }

        adapter.add();

        tabLayout = findViewById(R.id.AppointmentsTabLayout);
        viewPager = findViewById(R.id.AppointmentsPageViewer);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcons();

    }
    private void setTabIcons(){
        if(source.equals("book")){
            tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_book_online_24);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_group_24);
            tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_video_call_24);
        }else if(source.equals("view")){
            tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_group_24);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_video_call_24);
        }
    }
}