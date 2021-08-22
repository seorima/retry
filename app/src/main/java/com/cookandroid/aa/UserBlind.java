package com.cookandroid.aa;

public class UserBlind {

//    public String profile;
    public String blindName;
    public String blindPlace;
    public String blindToken;
  /*  public String Alarm_day;
    public String Alarm_height;
    public String Alarm_state;
    public String Alarm_time;*/

    public UserBlind() {

    }


    /*
        public String getAlarm_day() {
            return Alarm_day;
        }

        public void setAlarm_day(String alarm_day) {
            Alarm_day = alarm_day;
        }

        public String getAlarm_height() {
            return Alarm_height;
        }

        public void setAlarm_height(String alarm_height) {
            Alarm_height = alarm_height;
        }

        public String getAlarm_state() {
            return Alarm_state;
        }

        public void setAlarm_state(String alarm_state) {
            Alarm_state = alarm_state;
        }

        public String getAlarm_time() {
            return Alarm_time;
        }

        public void setAlarm_time(String alarm_time) {
            Alarm_time = alarm_time;
        }
    */
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
