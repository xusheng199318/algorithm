package com.arthur.dynamic;

import org.junit.Test;

public class SumSubArr {

    @Test
    public void testSumArr() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = maxSubArray(nums);
        System.out.println(sum);
    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
