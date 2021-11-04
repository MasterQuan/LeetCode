package com.quan.dynamic_programming;

public class MaxValue {
    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 ){
                    if (j == 0){
                        continue;
                    }else {
                        grid[i][j] += grid[i][j-1];
                    }
                }else {
                    if (j==0){
                        grid[i][j] += grid[i-1][j];
                    }else {
                        grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
                    }
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
