package com.designPatterns;

public class IndianCurrency extends Currency {
    double  value;

    public IndianCurrency() {
        description = "indian rupees";
    }

    @Override
    public double cost(double value) {
        this.value = value;
        return value;
    }
}
