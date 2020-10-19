package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SecondActivity extends AppCompatActivity implements Constants {
//    RadioButton rbCapital;
//    RadioButton rbHome;
//    EditText etLocation;
//    Button okbtn;
//    final static String clickedHomeKey = "HOME";
//    final static String clickedCapitalKey = "CAPITAL";
//    boolean isClickedHome;
//    boolean isClickedCapital;
//    final  MainPresentor presentor = MainPresentor.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

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
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
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