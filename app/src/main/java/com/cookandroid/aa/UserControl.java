package com.cookandroid.aa;

public class UserControl {

    public String userlight;

    public UserControl() {
    }

    public String getUserlight() {
        return userlight;
    }

    public void setUserlight(String userlight) {
        this.userlight = userlight;
    }

    public String toString() {
        return "Light{" +
                "set_lux='" + userlight + '\'' +
                '}';
    }
}
