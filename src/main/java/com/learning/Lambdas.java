package com.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambdas {

    public static void main(String args[]) {

        List<Person> persons = Arrays.asList(
                new Person("Sara",Gender.FEMALE,20,10000),
                new Person("Sara",Gender.FEMALE,22,10000),
                new Person("Bob",Gender.MALE,20,30000),
                new Person("Paula",Gender.FEMALE,32,40000),
                new Person("Paul",Gender.MALE,32,15000),
                new Person("Jack",Gender.MALE,2,90000),
                new Person("Jack",Gender.MALE,72,19000),
                new Person("Jill",Gender.FEMALE,12,16000)
        );

        int[] numbers = {28,5,78,6,4,-1,456,4};

       /* Game football = new Game() {
            @Override
            public void play() {
                System.out.println("playing football");
            }
        };

        Game fusingLambda = () -> System.out.println("playing football using lambda");

        fusingLambda.play();

        Series series = name -> System.out.println("Participating in "+name);
        series.play("IPL");

        Comparator<Person> personComparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Comparator<Person> personComparator1 = Comparator.comparing(Person::getName);




        IntStream.of(numbers)
                 .min()
                 .ifPresent(System.out::println);*/

        IntStream.of(numbers)
                  .distinct()
                  .sorted()
                  .limit(3)
                  .forEach(System.out::println);


        persons.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .limit(3)
                .map(Person::getName)
                .forEach(System.out::println);

        Map<Gender,List<Person>> groupingByGender = persons.stream()
                                                            .collect(Collectors.groupingBy(Person::getGender));

        groupingByGender.keySet()
                         .forEach(e->System.out.println("Gender "+ e+
                                 "employeeList"+groupingByGender.get(e)));
                                 //.stream().map(Person::getName).forEach(System.out::println)));

         Map<Gender,Long> genderCount =  persons.stream()
                 .collect(Collectors.groupingBy(Person::getGender,Collectors.counting()));

        genderCount.keySet()
                .forEach(e->System.out.println("Gender "+ e+
                        "   employeeCount  "+genderCount.get(e)));
    }


}

 interface Game {

    void play();

}

interface Series {

    void play(String name);

}
