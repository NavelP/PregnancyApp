package com.example.pregnancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class doctorAdapter extends RecyclerView.Adapter<doctorAdapter.MyHolder> {
    Context context;
    ArrayList<doctorsP> doctors;
    ActivityChanger activityChanger;

    public doctorAdapter(Context context, ArrayList<doctorsP> doctors, ActivityChanger activityChanger) {
        this.context = context;
        this.doctors = doctors;
        this.activityChanger = activityChanger;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_doctor_display, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.doctors_image.setImageResource(doctors.get(position).getImage());
        holder.doctors_name.setText(doctors.get(position).getDoctor_name());
        holder.doctors_department.setText(doctors.get(position).getDoctor_department());
        holder.doctors_specialization.setText(doctors.get(position).getDoctor_specialization());
        holder.doctors_hospital.setText(doctors.get(position).getDoctor_hospital());
        holder.doctors_location.setText(doctors.get(position).getDoctor_location());
        holder.book_appointment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityChanger.doctorsActivityChanger(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView doctors_name, doctors_department, doctors_specialization, doctors_hospital, doctors_location;
        Button book_appointment_button;
        ImageView doctors_image;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            doctors_name = itemView.findViewById(R.id.doctors_name);
            doctors_department = itemView.findViewById(R.id.doctors_department);
            doctors_specialization = itemView.findViewById(R.id.doctors_specialization);
            doctors_hospital = itemView.findViewById(R.id.doctors_hospital);
            doctors_location = itemView.findViewById(R.id.doctors_location);
            book_appointment_button = itemView.findViewById(R.id.book_appointmnet);
            doctors_image = itemView.findViewById(R.id.doctors_image);
        }

    }
}
