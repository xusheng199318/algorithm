package com.arthur.math;

import org.junit.Test;

public class PowerOfThree {

    @Test
    public void testPowerOfThree() {
        boolean powerOfThree = isPowerOfThree(8);
        System.out.println(powerOfThree);
    }

    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    /*public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }*/
}
