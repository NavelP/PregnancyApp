package com.example.pregnancy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AppointmentView extends Fragment {

    RecyclerView recyclerView;
    timeSlotsAdapter adapter;
    ArrayList<timeSlotsP> timeSlots;

    String doctors_name, doctors_specialization, doctors_department;
    int doctors_image;

    ImageView T_doctors_image;
    TextView T_doctors_name, T_doctors_department, T_doctors_specialization;

    Button makeAppointment;
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;

    public AppointmentView(String doctors_name, String doctors_specialization, String doctors_department, int doctors_image) {
        this.doctors_name = doctors_name;
        this.doctors_specialization = doctors_specialization;
        this.doctors_department = doctors_department;
        this.doctors_image = doctors_image;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.activity_appointment_view, container, false);

        makeAppointment = view.findViewById(R.id.make_appointment_button);

        alertDialogBuilder = new AlertDialog.Builder(getContext());

        View dialogView = getLayoutInflater().inflate(R.layout.confirmed_booking_display, null);

        alertDialogBuilder.setView(dialogView);

        dialogView.findViewById(R.id.dismiss_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();

        makeAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });

        timeSlots = new ArrayList<>();
        timeSlots.add(new timeSlotsP("12:00pm - 1:00pm"));
        timeSlots.add(new timeSlotsP("01:00pm - 1:30pm"));
        timeSlots.add(new timeSlotsP("12:00pm - 1:00pm"));
        timeSlots.add(new timeSlotsP("01:00pm - 1:30pm"));

        T_doctors_image = view.findViewById(R.id.a_doctors_image);
        T_doctors_name = view.findViewById(R.id.a_doctors_name);
        T_doctors_department = view.findViewById(R.id.a_doctors_department);
        T_doctors_specialization = view.findViewById(R.id.a_doctors_specialization);

        T_doctors_image.setImageResource(doctors_image);
        T_doctors_name.setText(doctors_name);
        T_doctors_specialization.setText(doctors_specialization);
        T_doctors_department.setText(doctors_department);

        recyclerView = view.findViewById(R.id.timeSlotsRecycleView);

        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new timeSlotsAdapter(getContext(), timeSlots);
        recyclerView.setAdapter(adapter);

        return view;
    }
}