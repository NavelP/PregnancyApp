package com.example.pregnancy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class QuestionsTabadapter extends FragmentPagerAdapter {

    ArrayList<String> tab_names = new ArrayList<>();

    public QuestionsTabadapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment f = null;

        switch (position){
            case 0:
                f = new AskQuestionTab();
                break;

            case 1:
                f = new AskedQuestionsTab();
                break;
        }

        return f;
    }

    @Override
    public int getCount() {
        return tab_names.size();
    }

    public void add(){
        tab_names.add("Ask Question");
        tab_names.add("Asked Questions");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab_names.get(position);
    }
}
