package com.cookandroid.aa;

public class User {

    public String blindName;
    public String place;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String blindName, String place) {
        this.blindName = blindName;
        this.place = place;
    }

    public String getblindName() {
        return blindName;
    }

    public void setblindName(String blindName) {
        this.blindName = blindName;
    }

    public String getplace() {
        return place;
    }

    public void setplace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Blind{" +
                "blindName='" + blindName + '\'' +
                ", place='" + place + '\'' +
                '}';
    }

}
