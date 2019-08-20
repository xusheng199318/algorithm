package com.arthur.string;

import org.junit.Test;

import java.util.HashMap;


public class UniqCharTest {

    @Test
    public void testUniqChar() {
        int leetcode = firstUniqChar("leetcode");
        System.out.println(leetcode);
    }

    /*public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean duplicate = false;
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                return i;
            }
        }
        return -1;
    }*/

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            resultMap.put(c, resultMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (resultMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
