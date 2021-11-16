package com.quan.dynamic_programming;

/**
 *
 */
public class translateNum {
    public int translateNum(int num) {
        if (num <= 9) return 1;
        int ba = num % 100;
        return (ba < 10|| ba > 25) ? translateNum(num / 10) : translateNum(num / 10) + translateNum(num / 100);
    }

    /**
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        //字符串位空，是否有前置零，以及30~00
        if (s == null || s.length() < 1) return 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '0') return 0;
            if (s.charAt(i) == '0' && s.charAt(i-1) != '1' && s.charAt(i-1) != '2') return 0;
        }
        return numDecodings(s);
    }
}
