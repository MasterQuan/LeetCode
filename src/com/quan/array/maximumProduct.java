package com.quan.array;

import java.util.Arrays;

/**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class maximumProduct {

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        if (nums[nums.length - 1] == 0) return 0;
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
