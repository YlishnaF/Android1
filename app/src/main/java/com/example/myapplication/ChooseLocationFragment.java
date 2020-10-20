package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;


public class ChooseLocationFragment extends Fragment {
    public static final String CURRENT_CITY = "CurrentCity";
    boolean isExistingWeather;
    Parcel currenrParcel;
    RadioButton rbCapital;
    RadioButton rbHome;
    EditText etLocation;
    Button okbtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_choose_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       initList(view);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(CURRENT_CITY, currenrParcel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isExistingWeather = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if(savedInstanceState != null){
            currenrParcel = (Parcel)savedInstanceState.getSerializable(CURRENT_CITY);
        } else {
            currenrParcel = new Parcel(getResources().getStringArray(R.array.cities)[0], 0, getResources().getStringArray(R.array.temperature)[0]);
        }
        if(isExistingWeather){
            showWeather(currenrParcel);
        }
    }

    private void initList(View view){
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linlay);

        String[] cities = getResources().getStringArray(R.array.cities);

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            TextView tv = new TextView(getContext());
            tv.setText(city);
            tv.setTextSize(15);
            tv.setTextColor(Color.parseColor("white"));
            linearLayout.addView(tv);

            final int fi = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currenrParcel = new Parcel(getResources().getStringArray(R.array.cities)[fi], fi, getResources().getStringArray(R.array.temperature)[fi]);
                }
            });

        }

    }

    private void showWeather(Parcel parcel){
        if(isExistingWeather){
            WeatherDetailsFragment detail = (WeatherDetailsFragment)getFragmentManager().findFragmentById(R.id.weatherDet);
            if(detail == null || detail.getParcel().getImageIndex() != parcel.getImageIndex()) {
                detail = WeatherDetailsFragment.create(parcel);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.weatherDet,detail);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }


        } else{
            Intent intent = new Intent(getContext(), WeatherDetailsFragment.class);
            intent.putExtra(WeatherDetailsFragment.PARCEL, parcel);
            startActivity(intent);
        }

    }


}