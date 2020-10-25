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

public class SecondActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final MainPresentor presentor = MainPresentor.getInstance();

        Button ok = findViewById(R.id.oklocationbtn);
//        EditText et = findViewById(R.id.editTextLocation);
//        et.setText(String.valueOf(presentor.getLocation()));

//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentResult = new Intent();
//                intentResult.putExtra(LOCATION, et.getText().toString());
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