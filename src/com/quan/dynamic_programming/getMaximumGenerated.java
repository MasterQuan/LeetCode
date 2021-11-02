package com.quan.dynamic_programming;

/**
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 *
 */
public class getMaximumGenerated {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] nums = new int[n + 1];
        nums[0] = 0; nums[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; ++i) {
            int k = nums[i] = (i & 1) == 0 ? nums[i >> 1] : nums[i >> 1] + nums[(i >> 1) + 1];
            if (k > max) max = k;
        }
        return max;
    }
}
