package com.quan.graph;

/**
 * 给定一个m x n 整数矩阵matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。
 * 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 */
public class LongestIncreasingPath {
//    private int max = 1;
//    public int longestIncreasingPath(int[][] matrix) {
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//        int[][] len = new int[matrix.length][matrix[0].length];
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                dfs(matrix, visited, i, j, -1, 0);
//                len[i][j] =
//            }
//        }
//        return max;
//    }
//
//    private void dfs(int[][] matrix, boolean[][] visited, int row, int col, int pre, int len){
//        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
//                || visited[row][col] ||  pre >= matrix[row][col])
//            return;
//        visited[row][col] = true;
//        len++;
//        max = len > max ? len : max;
//        dfs(matrix, visited, row - 1, col, matrix[row][col], len);
//        dfs(matrix, visited, row + 1, col, matrix[row][col], len);
//        dfs(matrix, visited, row, col - 1, matrix[row][col], len);
//        dfs(matrix, visited, row, col + 1, matrix[row][col], len);
//        visited[row][col] = false;
//    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] len = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                ans = Math.max(ans, dfs(len, i, j, -1, matrix));
            }
        }
        return ans;
    }

    public int dfs(int[][] arr, int row, int col, int pre, int[][] matrix){
        if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length) return 0;
        if(matrix[row][col] <= pre) return 0;
        if(arr[row][col] != 0) return arr[row][col];

        arr[row][col] = Math.max(arr[row][col], dfs(arr, row - 1, col, matrix[row][col], matrix));
        arr[row][col] = Math.max(arr[row][col], dfs(arr, row + 1, col, matrix[row][col], matrix));
        arr[row][col] = Math.max(arr[row][col], dfs(arr, row, col - 1, matrix[row][col], matrix));
        arr[row][col] = Math.max(arr[row][col], dfs(arr, row, col + 1, matrix[row][col], matrix));

        arr[row][col] += 1;
        return arr[row][col];
    }
}
