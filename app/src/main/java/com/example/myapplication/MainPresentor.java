package com.example.myapplication;

public final class MainPresentor {

    private static final MainPresentor instance = new MainPresentor();
    private String location = "Location";
    private MainPresentor(){
    }
    public String getLocation(){
        return location;
    }
    public static MainPresentor getInstance(){
        return instance;
    }
}
