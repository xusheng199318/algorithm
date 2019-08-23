package com.arthur.other;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class ValidBrackets {

    @Test
    public void testValidBrackets() {
        String str = "]";
        System.out.println(isValid(str));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char chara = s.charAt(i);
            if (chara == '(' || chara == '{' || chara == '[') {
                chars.push(chara);
            }
            if (!chars.isEmpty()) {
                if (chara == ')') {
                    if (chars.pop() != '(') {
                        return false;
                    }
                }
                if (chara == '}') {
                    if (chars.pop() != '{') {
                        return false;
                    }
                }
                if (chara == ']') {
                    if (chars.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return chars.size() == 0;
    }
}
