package com.arthur.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    @Test
    public void testFunction() {
        List<String> nums = Arrays.asList("1", "324", "42332", "123");
        //fun(nums, String::length);
        nums.stream().filter(num -> {
            int n = Integer.parseInt(num);
            return n >= 0;
        });
        nums.forEach(System.out::println);
    }

    private void fun(List<String> nums, Function<String, Integer> func) {
        for (String num : nums) {
            Integer apply = func.apply(num);
            System.out.println(apply);
        }
    }
}
