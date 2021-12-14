package com.quan.graph;

/**
 * 给定一个由0和1组成的非空二维数组grid，用来表示海洋岛屿地图。
 *
 * 一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 * 你可以假设grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 */
public class maxAreaOfIsland {
    int[][] parent;
    public int maxAreaOfIsland(int[][] grid) {
        int h = grid.length, w = grid[0].length, s = 0;
        parent = new int[h * w][2];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++,s++) {
                parent[s][0] = s;

                //是否第一行
                if (i==0){
                    //是否第一列
                    if(j==0){
                    }else {
                        if (grid[i][j] == 1 && grid[i][j-1] == 1){
                            union(s, s - 1);
                        }
                    }
                }else {
                    //是否第一列
                    if(j==0){
                        if (grid[i][j] == 1 && grid[i-1][j] == 1){
                            union(s, s - w);
                        }
                    }else {
                        if (grid[i][j] == 1){
                            if (grid[i][j-1] == 1){
                                union(s, s - 1);
                            }else if (grid[i-1][j] == 1){
                                union(s, s - w);
                            }
                        }
                    }
                }

            }
        }

        int max = 0;
        s=0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++,s++) {
                if (grid[i][j] == 1){
                    int A  = find(i);
                    parent[A][1] = parent[A][1] + 1;
                    max = Math.max(max, parent[A][1]);
                }
            }
        }
        return max;
    }

    private void union(int a, int b) {
        int A = find(a), B = find(b);
        if (A != B){
            parent[A][0] = B;
        }
    }

    private int find(int x) {
        if (x != parent[x][0]) {
            parent[x][0] = find(parent[x][0]);
        }
        return parent[x][0];
    }
}
