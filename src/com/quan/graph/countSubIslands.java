package com.quan.graph;

/**
 * 给你两个m x n的二进制矩阵grid1和grid2，它们只包含0（表示水域）和 1（表示陆地）。
 * 一个 岛屿是由 四个方向（水平或者竖直）上相邻的1组成的区域。任何矩阵以外的区域都视为水域。
 * 如果 grid2的一个岛屿，被grid1的一个岛屿完全 包含，
 * 也就是说grid2中该岛屿的每一个格子都被 grid1中同一个岛屿完全包含，
 * 那么我们称 grid2中的这个岛屿为 子岛屿。
 * 请你返回 grid2中 子岛屿的 数目。
 *
 */
public class countSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int num = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && sub(grid1, grid2, i, j)){
                    num++;
                }
            }
        }
        return num;
    }

    private boolean sub(int[][] grid1, int[][] grid2, int i, int j){
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length || grid2[i][j] == 0){
            return true;
        }
        if (grid1[i][j] == 0){
            return false;
        }

        grid2[i][j] = 0;
        boolean up = sub(grid1, grid2, i - 1, j);
        boolean down = sub(grid1, grid2, i + 1, j);
        boolean left = sub(grid1, grid2, i, j - 1);
        boolean right = sub(grid1, grid2, i, j + 1);
        return up && down && left && right;
    }
}
