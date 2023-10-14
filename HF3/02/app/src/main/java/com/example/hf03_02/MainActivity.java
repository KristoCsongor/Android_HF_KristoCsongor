package com.example.hf03_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> productsList = new ArrayList<>();

        EditText et1 = findViewById(R.id.code);
        EditText et2 = findViewById(R.id.name);
        EditText et3 = findViewById(R.id.price);

        Button addProduct = findViewById(R.id.addProductButton);
        Button cancelProduct = findViewById(R.id.cancelButton);
        Button showProducts = findViewById(R.id.showProductsButton);

        TextView tv = findViewById(R.id.textView5);

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int code = Integer.parseInt(et1.getText().toString().trim());
                    String name = et2.getText().toString();
                    double price = Double.parseDouble(et3.getText().toString().trim());

                    productsList.add(new Product(code, name, price));
                    cancelProduct.callOnClick(); // clear fields
                } catch (NumberFormatException e) {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect format!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        cancelProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
            }
        });

        showProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
                for (Product product : productsList) {
                    tv.append(product + "\n");
                }
            }
        });
    }
}