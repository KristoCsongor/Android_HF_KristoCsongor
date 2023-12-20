package com.example.customlistview2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] nameArray = {"Octopus", "Pig", "Sheep", "Rabbit",
            "Snake", "Spider", "Spider", "Spider", "Spider"};

    String[] infoArray = {
            "8 tentacled monster",
            "Delicious in rolls",
            "Great for jumpers",
            "Nice in a stew",
            "Great for shoes",
            "Scary",
            "Scary",
            "Scary",
            "Scary"
    };

    Integer[] imageArray = {
            R.drawable.cat,
            R.drawable.disznyo,
            R.drawable.dog,
            R.drawable.giraffe,
            R.drawable.horse,
            R.drawable.lion,
            R.drawable.octopus3,
            R.drawable.rabbit,
            R.drawable.sheep
    };

    RecyclerView myList;
    CustomListViewAdapter egyszeruAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = findViewById(R.id.myList);
        egyszeruAdapter = new CustomListViewAdapter(this, nameArray, infoArray, imageArray);
        myList.setAdapter(egyszeruAdapter);
        myList.setLayoutManager(new LinearLayoutManager(this));

    }
}