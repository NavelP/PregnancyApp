package com.example.pregnancy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class BookAppointment extends AppCompatActivity implements ActivityChanger{

    RecyclerView recyclerView;
    ArrayList<doctorsP> doctors;
    doctorAdapter adapter;

    EditText search_doctor;
    Button viewAppointments;

    ImageView doctorsBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        getSupportActionBar().hide();

        search_doctor = findViewById(R.id.search_doctor);

        search_doctor.setMinimumWidth((MainActivity.width - 300));

        viewAppointments = findViewById(R.id.viewAppointments);

        viewAppointments.setMinimumWidth(270);

        viewAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AppointmentsManager.class);
                intent.putExtra("source", "view");
                startActivity(intent);
            }
        });

        doctorsBack = findViewById(R.id.doctorsBack);

        doctorsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Tools.class));
            }
        });

        recyclerView = findViewById(R.id.doctorsRecycleView);

        doctors = new ArrayList<>();
        doctors.add(new doctorsP(R.drawable.notes, "Dr. Emmanuel Sankoh", "MBBS | FCPS (Dermatology)", "obstetrician",
                "Kenyatta Hospital", "Nairobi city, Kenya"));

        doctors.add(new doctorsP(R.drawable.appointment, "Dr. Dominic Kiptanui", "MBBS | FCPS (Dermatology)", "obstetrician",
                "Kenyatta Hospital", "Nairobi city, Kenya"));

        doctors.add(new doctorsP(R.drawable.meals, "Dr. Sharriff Odiwuor", "MBBS | FCPS (Dermatology)", "obstetrician",
                "Kenyatta Hospital", "Nairobi city, Kenya"));

        doctors.add(new doctorsP(R.drawable.childer_names, "Dr. Claud Mwangi John", "MBBS | FCPS (Dermatology)", "obstetrician",
                "Kenyatta Hospital", "Nairobi city, Kenya"));

        doctors.add(new doctorsP(R.drawable.questions, "Dr. Benson Muthui", "MBBS | FCPS (Dermatology)", "obstetrician",
                "Kenyatta Hospital", "Nairobi city, Kenya"));

        doctors.add(new doctorsP(R.drawable.userguide, "Dr. Emmanuel Sankoh", "MBBS | FCPS (Dermatology)", "obstetrician",
                "Kenyatta Hospital", "Nairobi city, Kenya"));

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new doctorAdapter(getApplicationContext(), doctors, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void toolsActivityChanger(int position) {

    }

    @Override
    public void doctorsActivityChanger(int position) {
        Intent intent = new Intent(getApplicationContext(), AppointmentsManager.class);
        intent.putExtra("source", "book");
        intent.putExtra("doctors_profile", doctors.get(position).getImage());
        intent.putExtra("doctors_name", doctors.get(position).getDoctor_name());
        intent.putExtra("doctors_department", doctors.get(position).getDoctor_department());
        intent.putExtra("doctors_specialization", doctors.get(position).getDoctor_specialization());

        startActivity(intent);
    }

    @Override
    public void readNotes(String noteTitle, String noteDate, String noteText) {

    }

    @Override
    public void loadTrimester(String trimester_number) {

    }
}