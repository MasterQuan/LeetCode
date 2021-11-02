package com.quan.dynamic_programming;

public class NumTrees {
    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * 返回满足题意的二叉搜索树的种数。
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 0) return 0;

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i-j-1];
            }
        }
        return nums[n];
    }
}
