package com.example.activitystatesavetwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // android:saveEnabled=“false” - beállítva az xml állományban
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. előadás, 16. oldal
        if (savedInstanceState == null) {
            Log.d("status", "onCreate() method was invoked without a previous state");
        } else {
            Log.d("status", "onCreate() method was invoked with a previous state");
        }
        /*EditText editText = findViewById(R.id.editTextText);
        CheckBox checkbox = findViewById(R.id.checkBox);*/
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText editText = findViewById(R.id.editTextText);
        CheckBox checkbox = findViewById(R.id.checkBox);
        outState.putString("editTextText", editText.getText().toString());
        outState.putBoolean("checked", checkbox.isChecked());
        Log.d("status", "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // 17. old.
        super.onRestoreInstanceState(savedInstanceState);
        EditText editText = findViewById(R.id.editTextText);
        CheckBox checkbox = findViewById(R.id.checkBox);
        if (savedInstanceState.getString("editTextText") != null) {
            editText.setText(savedInstanceState.getString("editTextText"));
        }
        checkbox.setChecked(savedInstanceState.getBoolean("checked"));
        Log.d("status", "onRestoreInstanceState()");
    }
}