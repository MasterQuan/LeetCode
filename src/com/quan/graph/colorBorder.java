package com.quan.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数row、col 和 color 。
 * 网格中的每个值表示该位置处的网格块的颜色。
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，
 * 或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 * 请你使用指定颜色color 为所有包含网格块grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格grid 。
 *
 */
public class colorBorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        List<int[]> borders = new LinkedList<>();
        int c = grid[row][col];
        infect(grid, row, col, c, borders);

        for (int[] pos:borders) {
            grid[pos[0]][pos[1]] = color;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    grid[i][j] = c;
            }
        }
        return grid;
    }

    public void infect(int[][] grid, int row, int col, int color, List<int[]> borders){
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != color)
            return;
        grid[row][col] = 0;
        if (grid[row][col] == 0
                && (row == 0
                || row == grid.length - 1
                || col == 0
                || col == grid[row].length - 1
                || (grid[row-1][col] != 0 && grid[row-1][col] != color)
                || (grid[row+1][col] != 0 && grid[row+1][col] != color)
                || (grid[row][col-1] != 0 && grid[row][col-1] != color)
                || (grid[row][col+1] != 0 && grid[row][col+1] != color))
        ){
            borders.add(new int[]{row,col});
        }
        infect(grid, row - 1, col, color, borders);
        infect(grid, row + 1, col, color, borders);
        infect(grid, row, col - 1, color, borders);
        infect(grid, row, col + 1, color, borders);
    }
}
