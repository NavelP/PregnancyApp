package com.example.pregnancy;

public class notesP {
    String notesTitle, notesText, notesDate;

    public notesP(String notesTitle, String notesText, String notesDate) {
        this.notesTitle = notesTitle;
        this.notesText = notesText;
        this.notesDate = notesDate;
    }

    public String getNotesTitle() {
        return notesTitle;
    }

    public void setNotesTitle(String notesTitle) {
        this.notesTitle = notesTitle;
    }

    public String getNotesText() {
        return notesText;
    }

    public void setNotesText(String notesText) {
        this.notesText = notesText;
    }

    public String getNotesDate() {
        return notesDate;
    }

    public void setNotesDate(String notesDate) {
        this.notesDate = notesDate;
    }
}
