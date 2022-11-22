package com.example.pregnancy;

public interface ActivityChanger {
    void toolsActivityChanger(int position);
    void doctorsActivityChanger(int position);
    void readNotes(String noteTitle, String noteDate, String noteText);
    void loadTrimester(String trimester_number);
}
