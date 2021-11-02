package com.quan.string;

public class Palindrome {
    public boolean isPalindrome(String s) {
        if (null == s) return false;
        String lowCase = s.toLowerCase();
        for (int i = 0, j = lowCase.length() - 1; i < j; ) {
            if (lowCase.charAt(i) >= '0' && lowCase.charAt(i) <='9'
                    || lowCase.charAt(i) >= 'a' && lowCase.charAt(i) <='z'){
                if (lowCase.charAt(j) >= '0' && lowCase.charAt(j) <='9'
                        || lowCase.charAt(j) >= 'a' && lowCase.charAt(j) <='z'){
                    if (lowCase.charAt(i) != lowCase.charAt(j)){
                        return false;
                    }else {
                        i++;
                        j--;
                    }
                }else {
                    j--;
                }
            }else {
                i++;
            }
        }
        return true;
    }
}
