package com.quan.dynamic_programming;

public class findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max_len = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i-1] + 1 : 1;
            max_len = Math.max(dp[i], max_len);
        }
        return max_len;
    }
}
