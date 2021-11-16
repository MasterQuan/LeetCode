package com.quan.dynamic_programming;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 */
public class maximalSquare {
    public int maximalSquare(char[][] matrix) {
        //dp[m][n]表示以mn为右下角的正方形的最大边长。
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
