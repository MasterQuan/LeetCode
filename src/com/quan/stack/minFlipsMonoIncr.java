package com.quan.stack;

import java.util.Stack;

public class minFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int count = 0;
        if (s == null || s.length() <= 1) return count;

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1'){
                stk.push(c);
            }else {
                if (!stk.isEmpty() && stk.peek() == '1'){
                    stk.pop();
                    count++;
                }
            }
        }
        return count;
    }

    public int minFlipsMonoIncr2(String s) {

        int one = 0, zero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                one = Math.min(zero, one) + 1;
            } else {
                one = Math.min(one, zero);
                zero++;
            }
        }
        return Math.min(one, zero);
    }

}
