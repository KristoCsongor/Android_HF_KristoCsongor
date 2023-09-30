package com.example.basicoperations;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et1 = findViewById(R.id.number1);
        EditText et2 = findViewById(R.id.number2);

        Button add = findViewById(R.id.addition);
        Button sub = findViewById(R.id.subtraction);
        Button mult = findViewById(R.id.multiplication);
        Button div = findViewById(R.id.division);

        TextView tv = findViewById(R.id.result);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double result = num1 + num2;
                    tv.setText(Double.toString(result));
                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect format!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double result = num1 - num2;
                    tv.setText(Double.toString(result));
                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect format!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    double result = num1 * num2;
                    tv.setText(Double.toString(result));
                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect format!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double num1 = Double.parseDouble(et1.getText().toString());
                    double num2 = Double.parseDouble(et2.getText().toString());
                    if(num2 == 0) {
                        Context context = getApplicationContext();
                        CharSequence text = "Division Error (/0)!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {
                        double result = num1 / num2;
                        tv.setText(Double.toString(result));
                    }
                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect format!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}