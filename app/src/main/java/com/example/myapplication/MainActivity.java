package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Constants {
    ImageView ivSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);

        ivSearch = findViewById(R.id.searchiv);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode!=REQUEST_CODE){
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if(resultCode == RESULT_OK){
            TextView location = findViewById(R.id.locationshowtv);
            location.setText(data.getStringExtra(LOCATION));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("MainActivity", "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        super.onSaveInstanceState(outState);
        Log.d("MainActivity", "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }
}