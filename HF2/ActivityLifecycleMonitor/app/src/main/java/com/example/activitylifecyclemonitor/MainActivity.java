package com.example.activitylifecyclemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("status", "MainActivity: onCreate");

        Button start = findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("status: ", "MainActivity: onStart ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("status: ", "MainActivity: onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("status: ", "MainActivity: onDestroy ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("status: ", "MainActivity: onPause ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("status: ", "MainActivity: onResume ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("status: ", "MainActivity: onRestart ");
    }
}