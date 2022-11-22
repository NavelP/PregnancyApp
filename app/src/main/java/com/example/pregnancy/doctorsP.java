package com.example.pregnancy;

public class doctorsP {
    String doctor_name, doctor_department, doctor_specialization, doctor_hospital, doctor_location;
    int image;

    public doctorsP(int image, String doctor_name, String doctor_department, String doctor_specialization, String doctor_hospital, String doctor_location) {
        this.doctor_name = doctor_name;
        this.doctor_department = doctor_department;
        this.doctor_specialization = doctor_specialization;
        this.doctor_hospital = doctor_hospital;
        this.doctor_location = doctor_location;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_department() {
        return doctor_department;
    }

    public void setDoctor_department(String doctor_department) {
        this.doctor_department = doctor_department;
    }

    public String getDoctor_specialization() {
        return doctor_specialization;
    }

    public void setDoctor_specialization(String doctor_specialization) {
        this.doctor_specialization = doctor_specialization;
    }

    public String getDoctor_hospital() {
        return doctor_hospital;
    }

    public void setDoctor_hospital(String doctor_hospital) {
        this.doctor_hospital = doctor_hospital;
    }

    public String getDoctor_location() {
        return doctor_location;
    }

    public void setDoctor_location(String doctor_location) {
        this.doctor_location = doctor_location;
    }
}
