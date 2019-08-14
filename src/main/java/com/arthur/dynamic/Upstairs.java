package com.arthur.dynamic;

import org.junit.Test;

public class Upstairs {

    @Test
    public void testClimbStairs() {
        int i = climbStairs(44);
        System.out.println(i);
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    /*public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        int result = 0;
        for (int i = 1; i <= 2; i++) {
            result += climbStairs(n - i);
        }
        return result;
    }*/
}
