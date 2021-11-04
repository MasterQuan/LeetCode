package com.quan.dynamic_programming;

/**
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 */
public class nthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglies = new int[n];
        uglies[0] = 1;
        int[] idx = new int[primes.length];
        int[] prod = new int[primes.length];
        for (int i = 1; i < uglies.length; i++) {
            uglies[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                prod[j] = uglies[idx[j]] * primes[j];
                uglies[i] = Math.min(uglies[i], prod[j]);
            }
            for (int j = 0; j < idx.length; j++) {
                idx[j] = uglies[i] == prod[j] ? idx[j] + 1 : idx[j];
            }
        }
        return uglies[n-1];
    }
}
