package com.quan.math;

public class arrangeCoins {
    public int arrangeCoins(int n) {
        long ns = (long) n << 1;
        long k = (long) Math.sqrt(ns);
        while (k * (k + 1) > ns) {
            k--;
        }
        return (int) k;
    }
}
