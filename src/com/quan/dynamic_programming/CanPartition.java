package com.quan.dynamic_programming;

public class CanPartition {
    /**
     * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
     *
     * 示例1：
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：nums 可以分割成 [1, 5, 5] 和 [11] 。
     *
     * 示例2：
     * 输入：nums = [1,2,3,5]
     * 输出：false
     * 解释：nums 不可以分为和相等的两部分
     *
     * 提示：
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        int sum = 0;
        //判断和为奇偶
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;

        //01背包问题，动态规划。
        sum >>= 1;
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for(int x : nums){
            for(int j = sum; j >= x; j--){
                f[j] |= f[j - x];
            }
        }
        return f[sum];
    }
}
