package com.example.hf04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView currencyList;


    Integer[] countryFlags = {
            R.drawable.eur,
            R.drawable.usd,
            R.drawable.gbp,
            R.drawable.aud,
            R.drawable.cad,
            R.drawable.chf,
            R.drawable.dkk,
            R.drawable.huf
    };

/*
    String[] currencyAbbrev = {"EUR", "USD", "GBP", "AUD", "CAD", "CHF", "DKK", "HUF"};
    String[] currencyNames = {
            "Euro",
            "Dolar american",
            "Liria sterlina",
            "Dolar australian",
            "Dolar canadian",
            "Franc elvetian",
            "Corona daneza",
            "Forint maghiar"
    };
    String[] buyValues = {
            "4,4100 RON",
            "3,9750 RON",
            "6,1250 RON",
            "2,9600 RON",
            "3,0950 RON",
            "4,2300 RON",
            "0,5850 RON",
            "0,0136 RON"
    };
    String[] sellValues = {
            "4,5500 RON",
            "4,1450 RON",
            "6,3550 RON",
            "3,0600 RON",
            "3,2650 RON",
            "4,3300 RON",
            "0,6150 RON",
            "0,0146 RON"
    };
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        int[] intArray = getResources().getIntArray(R.array.countryFlags);
        Integer[] countryFlags = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            countryFlags[i] = intArray[i];
        }
         */

        String[] currencyAbbrev = getResources().getStringArray(R.array.currencyAbbrev);
        String[] currencyNames = getResources().getStringArray(R.array.currencyNames);
        String[] buyValues = getResources().getStringArray(R.array.buyValues);
        String[] sellValues = getResources().getStringArray(R.array.sellValues);

        currencyList = findViewById(R.id.currencyList);
        CustomListViewAdapter customAdapter = new CustomListViewAdapter(
                this, countryFlags, currencyAbbrev, currencyNames, buyValues, sellValues
        );
        currencyList.setAdapter(customAdapter);

        currencyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = currencyAbbrev[position] + "\n" + buyValues[position];
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}