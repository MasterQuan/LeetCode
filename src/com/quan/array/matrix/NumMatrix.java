package com.quan.array.matrix;

public class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        //初始化外围为0；
        for (int i = 0; i < sums[0].length; i++) {
            sums[0][i] = 0;
        }
        for (int i = 0; i < sums.length; i++) {
            sums[i][0] = 0;
        }

        //初始化前缀和
        for (int i = 1; i < sums.length; i++) {
            int sum = 0;
            for (int j = 1; j < sums[0].length; j++) {
                sums[i][j] = sums[i][j-1] + sums[i-1][j] + matrix[i-1][j-1] - sums[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];
    }
}
