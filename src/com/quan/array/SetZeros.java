package com.quan.array;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return;
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }else continue;
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) setZerosOnRow(matrix, i);
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i]) setZerosOnCol(matrix, i);
        }

    }
    private void setZerosOnRow(int[][] matrix, int row){
        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = 0;
        }
    }


    private void setZerosOnCol(int[][] matrix, int col){
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

}
