package com.designPatterns;

public class SGDDecorator extends CurrencyDecorator {


    Currency currency;

    public SGDDecorator(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String getDescription() {
        return currency.getDescription()+" ,its singapore Dollar";
    }

    @Override
    public double cost(double value) {
        return currency.cost(value);
    }
}
