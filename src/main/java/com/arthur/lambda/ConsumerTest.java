package com.arthur.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    @Test
    public void testConsumer() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        forEach(nums, (num) -> System.out.println(num));
    }

    public void forEach(List<Integer> nums, Consumer consumer) {
        for (Integer num : nums) {
            consumer.accept(num);
        }
    }
}
