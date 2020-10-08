package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    RadioButton rbCapital;
    RadioButton rbHome;
    EditText etLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        rbCapital = findViewById(R.id.capitalrdt);
        rbHome = findViewById(R.id.homerbt);
        etLocation = findViewById(R.id.editTextLocation);
        rbCapital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Capital", Toast.LENGTH_SHORT).show();
            }
        });

        rbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
            }
        });

        etLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = etLocation.getText().toString();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

            }
        });

    }
}