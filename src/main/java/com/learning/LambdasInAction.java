package com.learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class LambdasInAction {

    public static void main(String[] args) throws IOException {

        //Apple.inventory.stream().filter(e->e.getWeight()>60).forEach(System.out::println);
        //Apple.inventory.stream().filter(e->e.getColour().equals("Green")).forEach(System.out::println);

       //Apple.filterApples(Apple.inventory,e->e.getWeight()>70).forEach(System.out::println);
        //Apple.filterApples(Apple.inventory,Apple::isHeavy).forEach(System.out::println);


        //Map<String, List<Apple>> applesByColour = Apple.inventory.stream().collect(groupingBy(Apple::getColour));
        //applesByColour.entrySet().forEach(System.out::println);

        //Apple.prettyPrintApple(Apple.inventory,Apple::getColour);

        //Apple.prettyPrintCustom(Apple.inventory,new Heavy());

       //String oneLine = processFile((BufferedReader b) -> b.readLine());

       // List<String> inputStrings = Arrays.asList("","abc");
        //Predicate<String> nonEmptyPredicate = (String str) -> !str.isEmpty();
        //inputStrings.stream().filter(nonEmptyPredicate).forEach(System.out::println);


        //map(inputStrings,String::length).forEach(System.out::println);

        //List<Integer> weightList = Arrays.asList(10,40,78,90,123,45,67);
        //mapUsingLambdaConstructor(weightList,Apple::new).forEach(System.out::println);

        //mapUsingLambdaConstructor1(weightList,Apple::new).forEach(System.out::println);

        //Function<Integer,Integer> increment = (x) ->x+1;
        //Function<Integer,Integer> multiply = (x) ->x*2;
        //Function<Integer,Integer> combine = increment.andThen(multiply);

        //System.out.println(combine.apply(1));



        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);

        System.out.println(numbers1.stream().reduce(0,(a,b)->a+b));
    //numbers1.stream().reduce(0,(a,b)->a+b);
        /*numbers1.stream()
                .map(n->n*n)
                .forEach(System.out::println);*/

        /*List<Integer> numbers2 = Arrays.asList(11,12,13);

        List<int[]> temp =numbers1.stream()
                .flatMap(i->numbers2.stream().map(j->new int[]{i,j}))
                .collect(toList());
        //System.out.println(temp);
        for (int[] temp1: temp) {
           Stream.of(temp1).forEach(System.out::println);
        }*/


        List<Dish> menu = Arrays.asList(
                new Dish("mutton", false, 800, Dish.Type.MEAT),
                new Dish("butterChicken", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
    }


    public static List<Apple> mapUsingLambdaConstructor(List<Integer> weightList,Function<Integer,Apple> function) {

        List<Apple> appleList = new ArrayList<>();

        for (Integer integer:weightList) {
            appleList.add(function.apply(integer));
        }

        return appleList;
    }

    public static List<Apple> mapUsingLambdaConstructor1(List<Integer> weightList, BiFunction<String,Integer,Apple> function) {

        List<Apple> appleList = new ArrayList<>();

        for (Integer integer:weightList) {
            appleList.add(function.apply("RED",integer));
        }

        return appleList;
    }

    public static List<Integer> map(List<String> strs, Function<String,Integer> function) {

        List<Integer> integers = new ArrayList<>();
        for (String str: strs) {

            integers.add(function.apply(str));

        }
        return  integers;
    }


    public static String processFile(BufferedReaderProcessor processor) throws IOException {

        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {

            return processor.process(br);

        }

    }
}
