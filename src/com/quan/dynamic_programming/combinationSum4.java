package com.quan.dynamic_programming;

/**
 * 给定一个由 不同正整数组成的数组 nums ，和一个目标整数 target 。
 * 请从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 数组中的数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 */
public class combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] cmb = new int[target + 1];
        cmb[0] = 1;
        int idx;
        for (int i = 1; i < cmb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                idx = i - nums[j];
                if (idx >= 0){
                    cmb[i] += cmb[idx];
                }
            }
        }

        return cmb[target];
    }
}
