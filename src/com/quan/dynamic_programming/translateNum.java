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
}
