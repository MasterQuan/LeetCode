package com.quan.dynamic_programming;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，
 * 在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 */
public class findTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, nums.length - 1, target);
    }
    private int findTargetSumWays(int[] nums, int pos, int target){
        if (pos == 0){
            if (nums[0] == 0 && target == nums[0]){
                return 2;
            }else if (nums[0] == target || -nums[0] == target){
                return 1;
            }else return 0;
        }else{
            return  findTargetSumWays(nums, pos - 1, target - nums[pos]) +
                    findTargetSumWays(nums, pos - 1, target + nums[pos]);
        }
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int w = (sum + target) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }
}
