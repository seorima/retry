package com.cookandroid.aa;

public class UserBlind {


    public String blindName;
    public String blindPlace;
    public String blindToken;


    public UserBlind() {

    }

    public String getBlindName() {
        return blindName;
    }

    public void setBlindName(String blindName) {
        this.blindName = blindName;
    }

    public String getBlindPlace() {
        return blindPlace;
    }

    public void setBlindPlace(String blindplace) {
        this.blindPlace = blindplace;
    }

    public String getBlindToken() {
        return blindToken;
    }

    public void setBlindToken(String blindToken) {
        this.blindToken = blindToken;
    }

    @Override
    public String toString() {
       return "Blind{" +
                "blindName='" + blindName + '\'' +
                ", place='" + blindPlace + '\'' +
                '}';
    }

}
