package com.arthur.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SumSolution {

    @Test
    public void testSum() {
        //int[] arr = {2, 7, 11, 15};
        int[] arr = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] result = twoSum(arr, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    /*private int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int next = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (next == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }*/

    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int next = target - nums[i];
            if (map.containsKey(next)) {
                return new int[] {map.get(next), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
