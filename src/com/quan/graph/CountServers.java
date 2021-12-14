package com.quan.graph;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在m * n的整数矩阵网格grid中，
 * 1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 */
public class CountServers {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for (int i = 0, count = 0; i < grid.length; i++, count = 0) {
            for (int j = 0; j < grid[0].length; j++) {
                count += grid[i][j];
            }
            rows[i] = count;
        }

        for (int i = 0,count = 0; i < grid[0].length; i++, count = 0) {
            for (int j = 0; j < grid.length; j++) {
                count += grid[j][i];
            }
            cols[i] = count;
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    if (rows[i] > 1 || cols[j] > 1) sum++;
                }
            }
        }
        return sum;
    }
}
