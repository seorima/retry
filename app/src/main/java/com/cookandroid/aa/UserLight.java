package com.cookandroid.aa;

public class UserLight {

    public int set_light;
  public Integer current_light;
    public String light_state;

    public UserLight() {
    }

    public String getLight_state() {
        return light_state;
    }

    public void setLight_state(String light_state) {
        this.light_state = light_state;
    }

 public Integer getCurrent_light() {
        return current_light;
    }

    public void setCurrent_light(Integer current_light) {
        this.current_light = current_light;
    }

    public int getSet_light() {
        return set_light;
    }

    public void setSet_light(int set_light) {
        this.set_light = set_light;
    }


}
