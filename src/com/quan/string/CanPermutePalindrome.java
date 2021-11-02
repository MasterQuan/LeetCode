package com.quan.string;

public class CanPermutePalindrome {
    public static void main(String[] args) {
        CanPermutePalindrome cp = new CanPermutePalindrome();

        System.out.println(cp.canPermutePalindrome("aab"));
        System.out.println(cp.canPermutePalindrome("aaab"));
    }
    public boolean canPermutePalindrome(String s) {
        if (null == s) return false;

        boolean[] chars = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)] = !chars[s.charAt(i)];
        }
        int ct = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]){
                ct++;
            }

        }
        return ct > 1 ? false : true;
    }
}
