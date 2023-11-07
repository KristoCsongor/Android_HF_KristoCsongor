package com.example.hf05_menu;

public class GyumolcsElem implements Comparable<GyumolcsElem> {
    private String name;
    private int color;

    GyumolcsElem(String name, int color) {
        this.name = name;
        this.color = color;
    }

    String getName() {
        return name;
    }

    int getColor() {
        return color;
    }

    @Override
    public int compareTo(GyumolcsElem other) {
        return this.name.compareTo(other.name);
    }
}
