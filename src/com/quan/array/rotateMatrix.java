package com.quan.array;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 *  
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class rotateMatrix {
    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length <= 1 || matrix.length != matrix[0].length) return;

        int length = matrix.length;
        for (int i = 0; i < (length / 2); i++) {
            int first = i;
            int last = length - 1 - first;
            for (int j = first; j < last; j++) {
                int offset = j - first;
                int tmp = matrix[first][j];
                matrix[first][j] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[j][last];
                matrix[j][last] = tmp;
            }
        }
    }
}
