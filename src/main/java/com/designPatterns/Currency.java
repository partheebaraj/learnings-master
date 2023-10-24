package com.designPatterns;

public abstract class Currency {

    String description ="unknown Dec";

    public String getDescription() {
        return description;
    }

    public abstract double cost(double value) ;

}
