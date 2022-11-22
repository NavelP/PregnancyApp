package com.example.pregnancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class upcomingAppointmentsAdapterOnline extends RecyclerView.Adapter<upcomingAppointmentsAdapterOnline.MyHolder>{
    Context context;
    ArrayList<upcomingAppointmentsP> upcomingAppointments;

    public upcomingAppointmentsAdapterOnline(Context context, ArrayList<upcomingAppointmentsP> upcomingAppointments) {
        this.context = context;
        this.upcomingAppointments = upcomingAppointments;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_upcoming_appointment_online, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.id.setText(upcomingAppointments.get(position).getId());
        holder.date.setText(upcomingAppointments.get(position).getDate());
        holder.name.setText(upcomingAppointments.get(position).getName());
        holder.time.setText(upcomingAppointments.get(position).getTime());
        holder.email.setText(upcomingAppointments.get(position).getEmail());
        holder.phoneNumber.setText(upcomingAppointments.get(position).getPhoneNumber());
        holder.bookingStatus.setText(upcomingAppointments.get(position).getBookingStatus());
        holder.paymentStatus.setText(upcomingAppointments.get(position).getPaymentStatus());

        if(upcomingAppointments.get(position).getPaymentStatus().equals("Paid")){
            holder.button.setText("Check your Booking");
        }

        holder.joinCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.cancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return upcomingAppointments.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView id, name, date, time, email, phoneNumber, bookingStatus, paymentStatus;
        Button button, joinCall, cancelBooking;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.appointmentID);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            email = itemView.findViewById(R.id.email);
            phoneNumber = itemView.findViewById(R.id.phoneNumber);
            bookingStatus = itemView.findViewById(R.id.Bstatus);
            paymentStatus = itemView.findViewById(R.id.Pstatus);
            button = itemView.findViewById(R.id.upButton);

            joinCall = itemView.findViewById(R.id.joinCall);
            cancelBooking = itemView.findViewById(R.id.cancelBooking);
        }
    }
}
