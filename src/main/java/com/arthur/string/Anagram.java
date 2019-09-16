package com.arthur.string;

import org.junit.Test;

public class Anagram {

    @Test
    public void testIsAnagram() {
        String s = "rat", t = "car";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] strs = new int[26];

        for (int i = 0; i < s.length(); i++) {
            strs[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            strs[t.charAt(i) - 'a']--;
            if (strs[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
