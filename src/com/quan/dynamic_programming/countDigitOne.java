package com.quan.dynamic_programming;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class countDigitOne {
    public static void main(String[] args) {
        int a = 0x33445566;
        System.out.println(100 & a);
    }

    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {

        }
        return sum;
    }
}
