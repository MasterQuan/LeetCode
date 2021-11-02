package com.quan.dynamic_programming;

public class CountBits {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 0;

        for (int i = 1; i <= n; i++) {
            counts[i] = counts[i & (i - 1)] + 1;
        }
        return counts;
    }
}
