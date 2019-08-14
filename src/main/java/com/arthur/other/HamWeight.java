package com.arthur.other;

import org.junit.Test;

public class HamWeight {

    @Test
    public void testHamWeight() {
        int i = hammingWeight(4);
        System.out.println(i);
    }

    public int hammingWeight(int n) {
        int sum = 0;

        while (n != 0) {
            sum++;
            n &= n-1;
        }

        return sum;
    }

    /*public int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                result++;
            }
            mask <<= 1;
        }

        return result;
    }*/
}
