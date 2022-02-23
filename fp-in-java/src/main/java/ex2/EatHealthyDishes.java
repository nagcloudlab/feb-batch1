package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EatHealthyDishes {
    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;
        List<String> lowCaloricDishesNames = getLowCaloricDishesNamesInJava7(menu);
        System.out.println(lowCaloricDishesNames);

        lowCaloricDishesNames=getLowCaloricDishesNamesInJava8(menu);
        System.out.println(lowCaloricDishesNames);


    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> menu) {

        return menu
                .stream()
                .parallel()
                .filter(d->d.getCalories()<400)
//                .sorted((d1,d2)->Integer.compare(d1.getCalories(),d2.getCalories()))
                .sorted(Comparator.comparing(Dish::getCalories))
//                .map(d->d.getName())
                .map(Dish::getName)
                .collect(Collectors.toList());

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

}
