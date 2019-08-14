package com.arthur.string;

import org.junit.Test;

public class RevertStr {

    @Test
    public void testRevertStr() {
        char[] str = new char[]{'H','a','n','n','a','h'};
        reverseString(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
