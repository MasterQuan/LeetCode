package com.quan.dynamic_programming;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 */
public class maxProduct {
    public int maxProduct(int[] nums) {
        int maxP = nums[0], minP = nums[0], ans = nums[0], max, min;
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            max = maxP;
            min = minP;
            maxP = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            minP = Math.min(max * nums[i], Math.min(nums[i], min * nums[i]));
            ans = Math.max(maxP, ans);
        }
        return ans;
    }
}
