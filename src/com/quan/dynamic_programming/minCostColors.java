package com.quan.dynamic_programming;

public class minCostColors {
    /**
     * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，
     * 你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
     * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
     * 每个房子粉刷成不同颜色的花费是以一个n x 3的正整数矩阵 costs 来表示的。
     *
     * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2]表示第 1 号房子粉刷成绿色的花费，
     * 以此类推。请计算出粉刷完所有房子最少的花费成本。
     * 示例 1：
     * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
     * 输出: 10
     * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。最少花费: 2 + 5 + 3 = 10。
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int r = 0, g = 0, b = 0;
        int cr, cg, cb;
        for (int i = 0; i < costs.length; i++) {
            cr = costs[i][0] + Math.min(g, b);
            cg = costs[i][1] + Math.min(r, b);
            cb = costs[i][2] + Math.min(r, g);
            r = cr;
            g = cg;
            b = cb;
        }
        return Math.min(Math.min(r, g), b);
    }
}
