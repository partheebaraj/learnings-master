package com.learning;

import java.util.function.Function;

public class LambdaFunctions {

    public static void main(String[] args) {

        Function<Integer,Integer>   doubleIt = e->e*2;
        System.out.println(doubleIt.apply(2));

        Function<Integer,Integer>   incrementIt = e->e+1;
        System.out.println(incrementIt.apply(2));

        //System.out.println("increment and doubleIf ",incrementIt.andThen(doubleIt));
        printIt(2,"increment and doubleIf ",incrementIt.andThen(doubleIt));

    }

    public static void printIt(int val,String msg,Function<Integer,Integer> function) {
        System.out.println(msg+" "+function.apply(val));
    }
}
