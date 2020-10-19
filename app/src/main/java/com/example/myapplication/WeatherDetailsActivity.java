package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class WeatherDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        if(savedInstanceState == null){
            Parcel parcel = (Parcel)getIntent().getSerializableExtra(WeatherDetailsFragment.PARCEL);
            WeatherDetailsFragment detais = WeatherDetailsFragment.create(parcel);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,detais)
                    .addToBackStack(null)
                    .commit();
        }
    }
}