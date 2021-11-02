package com.quan.string;

public class FirstUniqChar {
    public char firstUniqChar1(String s) {
        if(null == s || s.length() < 1){
            return ' ';
        }else {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 97]++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (count[s.charAt(i) - 97] == 1){
                    return s.charAt(i);
                }
            }
            return ' ';
        }
    }
}
