package com.learning;

public class Factorial {

    static final Factorial SEED = new Factorial(1,1);
    final int index;

    final  double value;

    public  Factorial(int index, double value) {
        this.index = index;
        this.value = value;
    }


    public Factorial next() {
        return  new Factorial(index+1,index*value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
