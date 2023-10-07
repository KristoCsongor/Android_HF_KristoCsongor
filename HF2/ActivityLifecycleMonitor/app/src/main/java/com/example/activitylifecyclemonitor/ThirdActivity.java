package com.example.activitylifecyclemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d("status: ", "ThirdActivity: onCreate ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("status: ", "ThirdActivity: onStart ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("status: ", "ThirdActivity: onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("status: ", "ThirdActivity: onDestroy ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("status: ", "ThirdActivity: onPause ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("status: ", "ThirdActivity: onResume ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("status: ", "ThirdActivity: onRestart ");
    }
}