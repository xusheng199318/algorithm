package com.arthur.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void testStream() {
        List<String> strNums = Arrays.asList("123", "0", "567", "987");
        List<Integer> collect = strNums.stream().filter(num -> {
            int intNum = Integer.parseInt(num);
            return intNum > 123;
        }).map(num -> Integer.parseInt(num) * 10).limit(1).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Stream<String> stream = strNums.stream();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        List<String> str = Arrays.asList("Hello", "World");
        str.stream().map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()).
                forEach(System.out::println);
    }

    @Test
    public void testFlatMap1() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.stream()
                .map(num -> num * num)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void testMap() {
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);
        List<int[]> collect = nums1.stream()
                .flatMap(num1 -> nums2.stream().map(num2 -> new int[]{num1, num2}))
                .collect(Collectors.toList());
        collect.forEach(nums -> Arrays.asList(nums).forEach(System.out::println));
    }
}
