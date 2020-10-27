package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements Constants {
    ImageView ivSearch;
    TextView locShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate");
        setContentView(R.layout.activity_main);
        SocSource sourceData = new SocSource(getResources());
        initRecyclerView(sourceData.build());
        SocSourceWeek socSourceWeek = new SocSourceWeek(getResources());
        initRecyclerViewWeek(socSourceWeek.build());

        ivSearch = findViewById(R.id.searchiv);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        locShow = findViewById(R.id.locationshowtv);
        locShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Location is empty", Snackbar.LENGTH_LONG)
                        .setAction("location", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                                startActivityForResult(intent, REQUEST_CODE);

                            }
                        }).show();

            }
        });
    }
    private void initRecyclerView(SocSource socSource){
        RecyclerView recyclerView = findViewById(R.id.recyclerv_whetaher_day);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        SocnetAdapter adapter = new SocnetAdapter(socSource);
        recyclerView.setAdapter(adapter);

    }
    private void initRecyclerViewWeek(SocSourceWeek socSourceWeek){
        RecyclerView recyclerView = findViewById(R.id.week);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SocnetAdapterWeek adapter = new SocnetAdapterWeek(socSourceWeek);
        recyclerView.setAdapter(adapter);

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