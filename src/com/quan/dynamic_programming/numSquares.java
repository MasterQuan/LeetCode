package com.quan.dynamic_programming;

/**
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class numSquares {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int pow = (int)Math.sqrt(n);
        int[] squares = new int[pow];
        for (int i = 1; i <= squares.length; i++) {
            squares[i-1] = i * i;
        }
        int[] dp = new int[n + 1];
        int idx, max = n + 1;
        for (int i = 1; i <=n ; i++) {
            dp[i] = max;
            for (int j = 0; j < squares.length; j++) {
                idx = i - squares[j];
                if (idx >= 0){
                    dp[i] = Math.min(dp[idx] + 1, dp[i]);
                }else break;
            }
            dp[i] = dp[i]==max ? 0 : dp[i];
        }
        return dp[n];
    }
}
