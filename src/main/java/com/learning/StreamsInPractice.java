package com.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class StreamsInPractice {

    Trader raoul = new Trader("Raoul", "Cambridge");

    Trader mario = new Trader("Mario","Milan");

    Trader alan = new Trader("Alan","Cambridge");

    Trader brian = new Trader("Brian","Cambridge");


    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {

      new StreamsInPractice().operate();


    }

    private void operate() {

        transactions.stream()
                .filter(e->e.getYear()==2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        transactions.stream().map(Transaction::getTrader)
                             .map(Trader::getCity)
                             .distinct()
                             .forEach(System.out::println);


        transactions.stream().map(Transaction::getTrader)
                .filter(e->e.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);


        System.out.println(transactions.stream().map(Transaction::getTrader)
                             .map(Trader::getName)
                              .distinct()
                             .sorted(Comparator.naturalOrder())
                             .reduce("",String::concat));

        System.out.println(transactions.stream().map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(joining()));



        System.out.println( transactions.stream().map(Transaction::getTrader)
                .anyMatch(e->e.getCity().equals("Milan")));

        transactions.stream()
                .filter(t->t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println(transactions.stream()
                    .map(Transaction::getValue)
                    .reduce(0,Integer::max));


        System.out.println(transactions.stream()
                     .min(Comparator.comparing(Transaction::getValue))
                     .orElse(new Transaction(new Trader("a","b"),2011,0)));






    }

}
