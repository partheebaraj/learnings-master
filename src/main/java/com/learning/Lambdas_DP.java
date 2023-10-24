package com.learning;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas_DP {

    public static void main(String args[]) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //numbers.forEach(System.out::println);

        //total aal values
        /*System.out.println(numbers.stream()
                .reduce(0,Integer::sum));

        System.out.println(numbers.stream()
                .filter(e->e%2==0)
                .reduce(0,Integer::sum));*/
        totalValues(numbers,e->true);
        totalValues(numbers,e->e%2==0);
        totalValues(numbers,e->e%2!=0);

        Function<Integer,Integer> inc = e->e+1;
        Function<Integer,Integer> doubleIt = e->e*2;

        apply(5,inc);
        apply(5,doubleIt);
        apply(5,inc.andThen(doubleIt));



    }

    public static void apply(Integer val,Function<Integer,Integer> func) {

        System.out.println(func.apply(val));

    }

    public static void totalValues(List<Integer> numbers, Predicate<Integer> sampler) {

        System.out.println(numbers.stream()
                .filter(sampler)
                .reduce(0,Integer::sum));

    }
}
