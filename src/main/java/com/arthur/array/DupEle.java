package com.arthur.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DupEle {

    @Test
    public void testDupEle() {
        int[] nums = new int[]{1,2,3, 1};
        boolean result = containsDuplicate(nums);
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        if (sets.size() != nums.length) {
            return true;
        }
        return false;
    }
}
