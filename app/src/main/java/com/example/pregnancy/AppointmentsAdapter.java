package com.example.pregnancy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class AppointmentsAdapter extends FragmentPagerAdapter {
    ArrayList<String> tabs = new ArrayList<>();

    String doctors_name, doctors_specialization, doctors_department, view_book;
    int doctors_image;

    public AppointmentsAdapter(@NonNull FragmentManager fm, String view_book, String doctors_name, String doctors_specialization, String doctors_department, int doctors_image) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.doctors_name = doctors_name;
        this.doctors_specialization = doctors_specialization;
        this.doctors_department = doctors_department;
        this.doctors_image = doctors_image;
        this.view_book = view_book;
    }

    public AppointmentsAdapter(@NonNull FragmentManager fm, String view_book){
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.view_book = view_book;
    }

    @NonNull
    @Override


    public Fragment getItem(int position) {
        Fragment tab = null;

        if(view_book.equals("view")){

            switch(position){
                case 0:
                    tab = new FaceToFace();
                    break;

                case 1:
                    tab = new VideoCaller();
                    break;
            }

        }else if(view_book.equals("book")){

            switch(position){
                case 0:
                    tab = new AppointmentView(doctors_name, doctors_specialization, doctors_department, doctors_image);
                    break;

                case 1:
                    tab = new FaceToFace();
                    break;

                case 2:
                    tab = new VideoCaller();
                    break;
            }
        }

        return tab;
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    public void add(){
        if(view_book.equals("view")){
            tabs.add("Face-to-Face");
            tabs.add("Online");
        }else if(view_book.equals("book")){
            tabs.add("Book");
            tabs.add("Face-to-Face");
            tabs.add("Online");
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}
