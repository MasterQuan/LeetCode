package com.quan.tow_pointers;

public class SubarrayProductLessThanK {
    /**
     * 给定一个正整数数组nums和整数 k，请找出该数组内乘积小于k的连续的子数组的个数。
     * <p>
     * 示例 1:
     * 输入: nums = [10,5,2,6], k = 100
     * 输出: 8
     * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        if (null == nums || nums.length < 1) return count;

        //先判断每位是否可以作为因子。
        boolean[] canProduce = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                canProduce[i] = false;
            } else {
                canProduce[i] = true;
                count++;
            }
        }

        for (int left = 0; left < nums.length; left++) {
            if (!canProduce[left]) {
                continue;
            } else {
                int produce = nums[left];
                int right = left + 1;
                while (right < nums.length && canProduce[right]) {
                    produce *= nums[right];
                    if (produce < k) {
                        count++;
                        right++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k == 0 || k == 1) return 0;
        int res = 0;
        int l = 0;
        int prod = 1; //存储nums[l]~nums[r]的累积
        for (int r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[l++];
            }
            res += r - l + 1;
        }
        return res;
    }
}
