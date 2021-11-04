package com.quan.dynamic_programming;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，
 * 其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 */
public class updateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length, max = row + col - 2;
        int[][] res = new int[row][col];
        //初始化res
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = mat[i][j] == 0 ? 0 : max;
            }
        }

        //从左上往右下update
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] != 0){
                    if (i == 0 && j == 0){
                        continue;
                    }else if (i == 0){
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                    }else if (j == 0){
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    }else {
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    }
                }
            }
        }

        //从右下往左上update
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (mat[i][j] != 0){
                    if (i == row - 1 && j == col - 1){
                        continue;
                    }else if (i == row - 1){
                        res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                    }else if (j == col - 1){
                        res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                    }else {
                        res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                        res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                    }
                }
            }
        }
        return res;
    }
}
