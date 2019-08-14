package com.arthur.array;

import org.junit.Test;

public class RemoveDup {

    @Test
    public void testRemoveDup() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        int cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (cur != nums[i]) {
                nums[result++] = cur;
                cur = nums[i];
            }
        }
        nums[result++] = cur;
        return result;
    }
}
