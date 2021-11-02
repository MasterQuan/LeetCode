package com.quan.array;

public class MaxSubArray {

    /**
     *给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
     *
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length < 1){
            return -1;
        }else {
            int res = nums[0];
            int sum = 0;
            for (int num : nums) {
                if (sum > 0)
                    sum += num;
                else
                    sum = num;
                res = res < sum ? sum : res;
            }
            return res;
        }
    }
}
