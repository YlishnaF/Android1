package com.example.myapplication;

public class Soc {
    private String time;
    private String temperature;
    private int picture;

    public Soc(String time, String temperature, int picture) {
        this.time = time;
        this.temperature = temperature;
        this.picture = picture;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public int getPicture() {
        return picture;
    }
}
