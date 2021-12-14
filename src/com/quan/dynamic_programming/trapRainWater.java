package com.quan.dynamic_programming;

public class trapRainWater {
    public int trapRainWater(int[][] heightMap) {
        int[][] max_left_up = new int[heightMap.length][heightMap[0].length];
        int[][] max_right_up = new int[heightMap.length][heightMap[0].length];
        int[][] max_left_down = new int[heightMap.length][heightMap[0].length];
        int[][] max_right_down = new int[heightMap.length][heightMap[0].length];

        //自左上至右下，求最小
        for (int i = 1; i < heightMap.length; i++) {
            for (int j = 1; j < heightMap[0].length; j++) {
                max_left_up[i][j] = Math.min(Math.max(max_left_up[i - 1][j], heightMap[i - 1][j]),
                        Math.max(max_left_up[i][j - 1], heightMap[i][j - 1]));
            }
        }

        //自右上至左下，求最小
        for (int i = 1; i < heightMap.length; i++) {
            for (int j = heightMap[0].length - 2; j >= 0; j--) {
                max_right_up[i][j] = Math.min(Math.max(max_right_up[i - 1][j], heightMap[i - 1][j]),
                        Math.max(max_right_up[i][j + 1], heightMap[i][j + 1]));
            }
        }

        //自左下至右上，求最小
        for (int i = heightMap.length - 2; i >= 0; i--) {
            for (int j = 1; j < heightMap[0].length; j++) {
                max_left_down[i][j] = Math.min(Math.max(max_left_down[i + 1][j], heightMap[i + 1][j]),
                        Math.max(max_left_down[i][j - 1], heightMap[i][j - 1]));
            }
        }

        //自右下至左上，求最小
        for (int i = heightMap.length - 2; i >= 0; i--) {
            for (int j = heightMap[0].length - 2; j >= 0; j--) {
                max_right_down[i][j] = Math.min(Math.max(max_right_down[i + 1][j], heightMap[i + 1][j]),
                        Math.max(max_right_down[i][j + 1], heightMap[i][j + 1]));
            }
        }

        int sum = 0;
        int min = 0;
        for (int i = 1; i < heightMap.length - 1; i++) {
            for (int j = 1; j < heightMap[0].length - 1; j++) {
                min = Math.min(Math.min(max_left_up[i][j], max_right_up[i][j]),
                        Math.min(max_left_down[i][j], max_right_down[i][j]));
                sum += min > heightMap[i][j] ? min - heightMap[i][j] : 0;
            }
        }
        return sum;
    }
}
