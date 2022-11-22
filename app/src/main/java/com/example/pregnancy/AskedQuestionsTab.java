package com.example.pregnancy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AskedQuestionsTab extends Fragment {

    public static ArrayList<askedQuestionsP> myQuestions;
    RecyclerView recyclerView;
    askedQuestionsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.asked_questions, container, false);

        recyclerView = view.findViewById(R.id.askedQuestionsRecycleView);

        recyclerView.setHasFixedSize(true);

        myQuestions = new ArrayList<>();
        myQuestions.add(new askedQuestionsP("Why does my stomach ache so much before bedtime?"));
        myQuestions.add(new askedQuestionsP("Does pregnancy affect the moods of an expectant mother? If yes, Why?"));
        myQuestions.add(new askedQuestionsP("Does the type of food that the mother takes during pregnancy affect the mental development of the unborn baby?"));
        myQuestions.add(new askedQuestionsP("Why does my stomach ache so much before bedtime?"));
        myQuestions.add(new askedQuestionsP("Does pregnancy affect the moods of an expectant mother? If yes, Why?"));
        myQuestions.add(new askedQuestionsP("Does the type of food that the mother takes during pregnancy affect the mental development of the unborn baby?"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new askedQuestionsAdapter(myQuestions, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
