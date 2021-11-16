package com.quan.dynamic_programming;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，
 * 找出只包含 1 的最大矩形，并返回其面积。
 */
public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int max_area = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return max_area;
        int[][]dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0){
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }else {
                    dp[i][j] = matrix[i][j] == '1' ? dp[i][j-1] + 1 : 0;
                }
            }
        }
        int area, width;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1'){
                    width = dp[i][j];
                    area = width;
                    for (int k = i - 1 ; k >= 0 ; k--) {
                        if (matrix[k][j] == '0'){
                            break;
                        }else {
                            width = Math.min(width, dp[k][j]);
                            area = Math.max(area, width * (i - k + 1));
                        }
                    }
                    max_area = Math.max(max_area,area);
                }
            }
        }
        return max_area;
    }
}
