package com.arthur.array;

import org.junit.Test;

public class RorateArr {

    @Test
    public void testRorate() {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(arr, 3);
    }

    public void rotate(int[] nums, int k) {
        int count = 0;
        for (int startIndex = 0; count < nums.length; startIndex++) {
            int currentIndex = startIndex;
            int preValue = nums[startIndex];
            do {
                int nextIndex = (currentIndex + k) % nums.length;
                int temp = nums[nextIndex];
                nums[nextIndex] = preValue;
                preValue = temp;
                currentIndex = nextIndex;
                count++;
            } while (startIndex != currentIndex);
        }

    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

}
