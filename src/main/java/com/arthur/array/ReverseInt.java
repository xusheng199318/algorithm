package com.arthur.array;

import org.junit.Test;

public class ReverseInt {

    @Test
    public void testReverseInt() {
        int result = reverse(-123);
        System.out.println(result);
    }

    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;

            int highLevel = Integer.MAX_VALUE / 10;
            if (rev >  highLevel || ((rev == highLevel) && pop > 7)) {
                return 0;
            }

            int lowLevel = Integer.MIN_VALUE / 10;
            if (rev < lowLevel || ((rev == lowLevel) && pop < -8)) {
                return 0;
            }
            rev = 10 * rev + pop;
            x = x / 10;
        }
        return rev;
    }
}
