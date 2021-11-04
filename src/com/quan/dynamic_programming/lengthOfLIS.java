package com.quan.dynamic_programming;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 */
public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        //初始化dp数组，初始化均为1；
        int[] dp = new int[nums.length];
        int max_len = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max_len = Math.max(dp[i], max_len);
        }
        return max_len;
    }
}
