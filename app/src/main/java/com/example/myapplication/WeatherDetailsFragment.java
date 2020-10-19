package com.example.myapplication;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class WeatherDetailsFragment extends Fragment {
    public static final String PARCEL = "parcel";

    public static WeatherDetailsFragment create(Parcel parcel){
        WeatherDetailsFragment fragment = new WeatherDetailsFragment();

        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }
    public Parcel getParcel(){
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView weather = view.findViewById(R.id.imageViewWeather);
        TextView temperature = view.findViewById(R.id.temperatureTV);

        TypedArray imgs = getResources().obtainTypedArray(R.array.weather);
        Parcel parcel = getParcel();

        weather.setImageResource(imgs.getResourceId(parcel.getImageIndex(), -1));
        temperature.setText(parcel.getTemperature());
    }
}