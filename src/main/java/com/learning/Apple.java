package com.learning;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
public class Apple {

    static List<Apple> inventory = Arrays.asList(new Apple("Red",50),new Apple("Green",100),
            new Apple("Yellow",70),new Apple("Red",81),new Apple("Red",89),
            new Apple("Green",85),new Apple("Pink",54));

    String colour;

    int weight;

    public Apple(String colour, int weight) {
        this.colour = colour;
        this.weight = weight;
    }

    public Apple(int weight)
    {
        this.weight = weight;
        this.colour = "RED";
    }

    @Override
    public String toString() {
        return "Apple["+this.colour+""+this.weight+"]";
    }


    public boolean isGreen(Apple apple) {
        return "Green".equals(apple.getColour());
    }

    public static boolean isHeavy(Apple apple) {
        return apple.weight>70;
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {

       /* List<Apple> filteredApples = new ArrayList<>();

        for(Apple apple:inventory) {
            if (predicate.test(apple)) {
                 filteredApples.add(apple);
            }
        }*/

        return inventory.stream().filter(predicate).collect(Collectors.toList());
    }

    static void prettyPrintApple(List<Apple> inventory, Function<Apple,Object> function) {

          inventory.stream().map(function).forEach(System.out::println);
    }

    static void prettyPrintCustom(List<Apple> inventory, Function1 function) {

        for(Apple apple : inventory) {
            String output = function.apply(apple);
            System.out.println(output);
        }
    }



}


class Weight implements Function1 {

    @Override
    public String apply(Apple a) {
        return String.valueOf(a.getWeight());
    }
}

class Heavy implements Function1 {

    @Override
    public String apply(Apple a) {
        return String.valueOf(Apple.isHeavy(a));
    }
}
