package com.example.pregnancy;

public class guideP {
    String trimesterNumber, getTrimesterText;
    int trimesterImage;

    public guideP(String trimesterNumber, String getTrimesterText, int trimesterImage) {
        this.trimesterNumber = trimesterNumber;
        this.getTrimesterText = getTrimesterText;
        this.trimesterImage = trimesterImage;
    }

    public String getTrimesterNumber() {
        return trimesterNumber;
    }

    public void setTrimesterNumber(String trimesterNumber) {
        this.trimesterNumber = trimesterNumber;
    }

    public String getGetTrimesterText() {
        return getTrimesterText;
    }

    public void setGetTrimesterText(String getTrimesterText) {
        this.getTrimesterText = getTrimesterText;
    }

    public int getTrimesterImage() {
        return trimesterImage;
    }

    public void setTrimesterImage(int trimesterImage) {
        this.trimesterImage = trimesterImage;
    }
}
