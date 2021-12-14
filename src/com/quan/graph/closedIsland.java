package com.quan.graph;

/**
 * 有一个二维矩阵 grid，每个位置要么是陆地（记号为0 ）要么是水域（记号为1 ）。
 * 我们从一块陆地出发，每次可以往上下左右4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
 * 如果一座岛屿完全由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
 * 请返回封闭岛屿的数目。
 *
 */
public class closedIsland {
    public int closedIsland(int[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && infect(grid, i, j)){
                    num++;
                }
            }
        }
        return num;
    }
    private boolean infect(int[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ) return false;
        if (grid[i][j] == 0){
            grid[i][j] = 1;
//            return infect(grid, i - 1, j)
//                    && infect(grid, i + 1, j)
//                    && infect(grid, i, j - 1)
//                    && infect(grid, i, j + 1);
            boolean up =  infect(grid, i - 1, j);
            boolean down = infect(grid, i + 1, j);
            boolean left = infect(grid, i, j - 1);
            boolean right = infect(grid, i, j + 1);
            return up && down && left && right;
        }
        return true;
    }
}
