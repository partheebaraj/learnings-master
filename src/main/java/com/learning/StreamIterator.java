package com.learning;

import java.util.stream.Stream;

public class StreamIterator {

    public static void main(String[] args) {

        //Stream.iterate(Pair.SEED,Pair::next).forEach(System.out::println);
        Stream.iterate(Factorial.SEED,Factorial::next).forEach(System.out::println);

    }
}


