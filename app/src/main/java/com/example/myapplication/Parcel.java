package com.example.myapplication;

import java.io.Serializable;

public class Parcel implements Serializable {
    private final String city;
    private final int imageIndex;
    private final String temperature;

    public int getImageIndex() {
        return imageIndex;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getCity() {
        return city;
    }

    public Parcel(String city, int imageIndex, String temperature) {
        this.city = city;
        this.imageIndex = imageIndex;
        this.temperature = temperature;
    }
}
