package com.quan.dynamic_programming;

public class UniquePaths {
    public int uniquePaths1(int m, int n) {
        if (m < 0 || n < 0) return -1;
        int[][] paths = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i][j-1] + paths[i-1][j];
            }
        }
        return paths[m-1][n-1];
    }

    //数学公式
    public int uniquePaths(int m, int n) {
        return (int)(factorial(m + n - 2) / factorial(m - 1)/ factorial(n - 1));
    }
    private long factorial(long n){
        return n > 0 ? factorial(n - 1) * n : 1;
    }


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[][] paths = new int[m][n];
        paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        //初始化
        for (int i = 1; i < m; i++) {
            paths[i][0] = obstacleGrid[i][0] == 1 ? 0 : paths[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            paths[0][i] = obstacleGrid[0][i] == 1 ? 0 : paths[0][i-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = obstacleGrid[i][j] == 1 ? 0 :  paths[i-1][j] + paths[i][j-1];
            }
        }

        return paths[m-1][n-1];
    }
}
