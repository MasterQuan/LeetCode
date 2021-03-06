package com.quan.math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }else {

            return palindrome(String.valueOf(x));
        }
    }

    private boolean palindrome(String s){
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }else continue;
        }
        return true;
    }
}
