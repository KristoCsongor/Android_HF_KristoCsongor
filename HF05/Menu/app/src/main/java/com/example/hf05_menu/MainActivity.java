package com.example.hf05_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView gyumolcsLista;
    ArrayList<String> gyumolcsElemek = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ArrayList<String> colors;
    Map<String, Integer> colorMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gyumolcsLista = findViewById(R.id.gyumolcsLista);
        String[] gyumolcsok = getResources().getStringArray(R.array.gyumolcsok);
        for (String gyumolcs : gyumolcsok) {
            colorMap.put(gyumolcs, android.R.color.white);
        }

        gyumolcsElemek.addAll(Arrays.asList(gyumolcsok));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gyumolcsElemek);
        gyumolcsLista.setAdapter(adapter);
        registerForContextMenu(gyumolcsLista);

        colors = new ArrayList<>();

        for (int i = 0; i < gyumolcsok.length; i++) {
            colors.add("white");
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_layout, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu_layout, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //View view = info.targetView;

        String kivalasztottGyumolcs = adapter.getItem(info.position);

        if (item.getItemId() == R.id.pirosId) {
            colorMap.put(kivalasztottGyumolcs, android.R.color.holo_red_light);
            updateListColors();
            return true;
        } else if (item.getItemId() == R.id.zoldId) {
            colorMap.put(kivalasztottGyumolcs, android.R.color.holo_green_light);
            updateListColors();
            return true;
        } else if (item.getItemId() == R.id.sargaId) {
            colorMap.put(kivalasztottGyumolcs, android.R.color.holo_orange_light);
            updateListColors();
            return true;
        } else {
            return super.onContextItemSelected(item);
        }

        /*if (item.getItemId() == R.id.pirosId) {
            ((TextView) view).setTextColor(Color.RED);
            colors.set(info.position, "red");

            Log.d("status", String.valueOf(info.position));
            Log.d("status", colors.get(info.position));

            return true;
        } else if (item.getItemId() == R.id.zoldId) {
            ((TextView) view).setTextColor(Color.GREEN);
            colors.set(info.position, "green");

            Log.d("status", String.valueOf(info.position));
            Log.d("status", colors.get(info.position));

            return true;
        } else if (item.getItemId() == R.id.sargaId) {
            ((TextView) view).setTextColor(Color.YELLOW);
            colors.set(info.position, "yellow");

            Log.d("status", String.valueOf(info.position));
            Log.d("status", colors.get(info.position));

            return true;
        }
        return super.onContextItemSelected(item);
         */
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.rendez) {
            //adapter.sort(String::compareTo);
            sortListAlphabetically();
            return true;
        } else if (item.getItemId() == R.id.torol) {
            adapter.clear();
            colorMap.clear();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateListColors() {
        for (int i = 0; i < adapter.getCount(); i++) {
            String gyumolcs = adapter.getItem(i);
            int color = colorMap.get(gyumolcs);
            View view = gyumolcsLista.getChildAt(i);
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(getResources().getColor(color));
            }
        }
    }

    private void sortListAlphabetically() {

        List<GyumolcsElem> items = new ArrayList<>();
        for (int i = 0; i < adapter.getCount(); i++) {
            String name = adapter.getItem(i);
            int color = colorMap.get(name);
            items.add(new GyumolcsElem(name, color));
        }

        Collections.sort(items);

        adapter.clear();
        colorMap.clear();

        for (GyumolcsElem item : items) {
            adapter.add(item.getName());
            colorMap.put(item.getName(), item.getColor());
        }

        updateListColors();
    }
}



