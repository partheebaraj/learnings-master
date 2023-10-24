package com.designPatterns;

public class Dollar extends Currency {

    double value;

    public  Dollar() {
        description = "Dollar";
    }

    @Override
    public double cost(double value) {
        this.value = value;
        return value;
    }
}
