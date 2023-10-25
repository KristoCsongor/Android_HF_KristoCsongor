package com.example.hf04;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListViewAdapter extends ArrayAdapter {
    private final Activity context;
    private final Integer[] countryFlags;
    private final String[] currencyAbbrev;
    private final String[] currencyNames;
    private final String[] buyValues;
    private final String[] sellValues;


    public CustomListViewAdapter(
            Activity context,
            Integer[] countryFlags,
            String[] currencyAbbrev,
            String[] currencyNames,
            String[] buyValues,
            String[] sellValues
    ) {
        super(context, R.layout.list_element, currencyAbbrev);
        this.context = context;
        this.countryFlags = countryFlags;
        this.currencyAbbrev = currencyAbbrev;
        this.currencyNames = currencyNames;
        this.buyValues = buyValues;
        this.sellValues = sellValues;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // ea4/30
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_element, null, true);

        ImageView countryFlag = rowView.findViewById(R.id.countryFlag);
        TextView currencyName = rowView.findViewById(R.id.currencyName);
        TextView currencyAbbrev = rowView.findViewById(R.id.currencyAbbrev);
        TextView buyValue = rowView.findViewById(R.id.buyValue);
        TextView sellValue = rowView.findViewById(R.id.sellValue);

        countryFlag.setImageResource(countryFlags[position]);
        currencyName.setText(currencyNames[position]);
        currencyAbbrev.setText(this.currencyAbbrev[position]);
        buyValue.setText(buyValues[position]);
        sellValue.setText(sellValues[position]);

        return rowView;
    }

}
