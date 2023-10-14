package com.example.hf03_02;

import androidx.annotation.NonNull;

public class Product {
    private int code;
    private String name;
    private double price;

    public Product(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}
