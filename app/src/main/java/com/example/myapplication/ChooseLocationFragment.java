package com.example.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
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
    Parcel currenrParsel;
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
        outState.putSerializable(CURRENT_CITY, currenrParsel);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isExistingWeather = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if(savedInstanceState != null){
            currenrParsel = (Parcel)savedInstanceState.getSerializable(CURRENT_CITY);
        } else {
            currenrParsel = new Parcel(getResources().getStringArray(R.array.cities)[0], 0, getResources().getStringArray(R.array.temperature)[0]);
        }
        if(isExistingWeather){
            showWeather(currenrParsel);
        }
    }

    private void initList(View view){
        LinearLayout linearLayout = (LinearLayout) view;
        linearLayout.findViewById(R.id.linlay);
        String[] cities = getResources().getStringArray(R.array.cities);

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            TextView tv = new TextView(getContext());
            tv.setText(city);
            tv.setTextSize(30);

            linearLayout.addView(tv);

            final int fi = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currenrParsel = new Parcel(getResources().getStringArray(R.array.cities)[fi], fi, getResources().getStringArray(R.array.temperature)[fi]);
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

    //    RadioButton rbCapital;
//    RadioButton rbHome;
//    EditText etLocation;
//    Button okbtn;
//    final static String clickedHomeKey = "HOME";
//    final static String clickedCapitalKey = "CAPITAL";
//    boolean isClickedHome;
//    boolean isClickedCapital;
//    final  MainPresentor presentor = MainPresentor.getInstance();
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_choose_location);
//
//        String instanceState;
//        if(savedInstanceState == null){
//            instanceState="First start";
//        } else {
//            instanceState = "Restart";
//            Log.d("SecondActivity", "RadioBtn");
//            isClickedHome = savedInstanceState.getBoolean(clickedHomeKey);
//            isClickedCapital = savedInstanceState.getBoolean(clickedCapitalKey);
//        }
//
//        rbCapital = findViewById(R.id.capitalrdt);
//        rbHome = findViewById(R.id.homerbt);
//
//        isClickedHome = rbHome.isSelected();
//        isClickedCapital = rbCapital.isSelected();
//
//        etLocation = findViewById(R.id.editTextLocation);
//        etLocation.setText(String.valueOf(presentor.getLocation()));
//
//        okbtn = findViewById(R.id.oklocationbtn);
//        okbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentResult = new Intent();
//                intentResult.putExtra(LOCATION, etLocation.getText().toString());
//                setResult(RESULT_OK, intentResult);
//                finish();
//            }
//        });
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        outState.putBoolean(clickedHomeKey, isClickedHome);
//        outState.putBoolean(clickedCapitalKey,isClickedCapital);
//        super.onSaveInstanceState(outState);
//
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        isClickedHome = savedInstanceState.getBoolean(clickedHomeKey);
//        isClickedCapital = savedInstanceState.getBoolean(clickedCapitalKey);
//        Log.d("SecondActivity", "onRestoreInstanceState - radiobutton");
//    }
}