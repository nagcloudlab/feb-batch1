package ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Apple {

    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}

public class FilteringApples {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // declarative style + FUNCTION => Functional Programming
        List<Apple> greenApples = filterApples(inventory,apple-> apple.getColor().equals("green"));
        System.out.println(greenApples);
        List<Apple> heavyApples=filterApples(inventory,apple -> apple.getWeight()>150);
        System.out.println(heavyApples);


    }
    private static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                list.add(apple);
            }
        }
        return list;
    }
}
