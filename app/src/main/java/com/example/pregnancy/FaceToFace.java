package com.example.pregnancy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FaceToFace extends Fragment {

    RecyclerView recyclerView;
    ArrayList<upcomingAppointmentsP> appointments;
    upcomingAppointmentsAdapterPhysical adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup container, @Nullable Bundle bundle){
        View view = layoutInflater.inflate(R.layout.activity_upcoming_appointments_physical, container, false);

        recyclerView = view.findViewById(R.id.upcomingAppointmentsRecycleView);

        recyclerView.setHasFixedSize(true);

        appointments = new ArrayList<>();
        appointments.add(new upcomingAppointmentsP("ID #1234567", "John Claud", "claudmwangi@gmail.com", "+2547920838",
                "Pending", "Unpaid", "31-03-2022", "08:00am"));
        appointments.add(new upcomingAppointmentsP("ID #1234595", "John Claud", "claudmwangi@gmail.com", "+2547920838",
                "Pending", "Paid", "31-04-2022", "04:00pm"));
        appointments.add(new upcomingAppointmentsP("ID #1234567", "John Claud", "claudmwangi@gmail.com", "+2547920838",
                "Pending", "Unpaid", "22-03-2022", "10:00am"));
        appointments.add(new upcomingAppointmentsP("ID #1234567", "John Claud", "claudmwangi@gmail.com", "+2547920838",
                "Successful", "Paid", "01-03-2022", "12:00pm"));
        appointments.add(new upcomingAppointmentsP("ID #1234567", "John Claud", "claudmwangi@gmail.com", "+2547920838",
                "Pending", "Unpaid", "31-03-2022", "08:00am"));
        appointments.add(new upcomingAppointmentsP("ID #1234567", "John Claud", "claudmwangi@gmail.com", "+2547920838",
                "Successful", "Unpaid", "31-03-2022", "08:00am"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new upcomingAppointmentsAdapterPhysical(getContext(), appointments);
        recyclerView.setAdapter(adapter);

        return view;
    }

}