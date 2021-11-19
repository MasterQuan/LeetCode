package com.quan.array;

/**
 * 给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，
 * 其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。
 * 返回构建好的数组 ans 。
 * 从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）
 * 的不同整数组成的数组。
 */
public class BuildArray {
    public static void main(String[] args) {
        //图中顶点数量
        int V = 100;
        //距离矩阵，需要初始化，可以直接复制图的邻接矩阵作为初始化结果
        int[][] d = new int[V][V];
        for (int v = 0; v < V; v++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    //状态转移方程
                    d[i][j] = Math.min(d[i][j], d[i][v] + d[v][j]);
                }
            }
        }
    }

}
