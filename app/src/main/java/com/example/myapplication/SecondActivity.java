package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity implements Constants {
    TextInputEditText locTv;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final MainPresentor presentor = MainPresentor.getInstance();

        btnOK = findViewById(R.id.oklocationbtn);
        locTv = findViewById(R.id.location_et);

//        btnOK.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentResult = new Intent();
//                intentResult.putExtra(LOCATION, locTv.getText().toString());
//                setResult(RESULT_OK,intentResult);
//                finish();
//            }
//        });

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new ChooseLocationFragment())
                    .commit();
        }

    }


}