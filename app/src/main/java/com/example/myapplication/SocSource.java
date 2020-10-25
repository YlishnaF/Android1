package com.example.myapplication;

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class SocSource {
    private List<Soc> dataSource;
    private Resources resources;

    public SocSource(Resources resources) {
        dataSource = new ArrayList<>(4);
        this.resources = resources;
    }

    public SocSource build(){
        String [] time = resources.getStringArray(R.array.time);
        String [] temperature = resources.getStringArray(R.array.temperaturema);
        int [] picutre = getImageArray();
        for (int i = 0; i < time.length; i++) {
            dataSource.add(new Soc(time[i], temperature[i], picutre[i]));
        }
        return this;

    }

    public Soc getSoc(int position){
        return dataSource.get(position);
    }

    public int size(){
        return dataSource.size();
    }

    private int[] getImageArray(){
        TypedArray pictures = resources.obtainTypedArray(R.array.picture);
        int length = pictures.length();
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            answer[i] = pictures.getResourceId(i, 0);
        }
        return answer;
    }


}

