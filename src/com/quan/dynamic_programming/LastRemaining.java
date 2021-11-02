package com.quan.dynamic_programming;

public class LastRemaining {
    public int lastRemaining(int n, int m) {
        if(n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
