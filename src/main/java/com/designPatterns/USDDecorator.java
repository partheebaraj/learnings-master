package com.designPatterns;

public class USDDecorator extends CurrencyDecorator {

    Currency currency;

    public USDDecorator(Currency currency){
        this.currency = currency;
    }

    @Override
    public String getDescription() {
        return currency.getDescription()+" ,its US Dollar";
    }

    @Override
    public double cost(double value) {
        return currency.cost(value);
    }
}
