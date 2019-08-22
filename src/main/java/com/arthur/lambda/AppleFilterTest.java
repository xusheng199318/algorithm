package com.arthur.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilterTest {

    @Test
    public void testAppleFilter() {
        List<Apple> apples = Arrays.asList(
                new Apple("green", 10),
                new Apple("red", 20),
                new Apple("blue", 30));
        List<Apple> greenApples = appleFilter(apples, Apple::isGreenApple);
        greenApples.forEach((apple -> System.out.println(apple)));
        List<Apple> redApples = appleFilter(apples, apple -> "red".equals(apple.color));
        redApples.forEach(System.out::println);
    }

    public List<Apple> appleFilter(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    static class Apple {
        private String color;
        private int weight;

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        private static boolean isGreenApple(Apple apple) {
            return "green".equals(apple.color);
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
