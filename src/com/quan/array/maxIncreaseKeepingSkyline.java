package com.quan.array;

/**
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。
 * 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
 * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。
 * 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
 * 建筑物高度可以增加的最大总和是多少？
 */
public class maxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] leftSkyline = new int[grid.length];
        int[] upSkyline = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                 upSkyline[j] = Math.max(upSkyline[j], grid[i][j]);
                 max = Math.max(max, grid[i][j]);
            }
            leftSkyline[i] = max;
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sum += Math.min(leftSkyline[i], upSkyline[j]) - grid[i][j];
            }
        }
        return sum;
    }
}
