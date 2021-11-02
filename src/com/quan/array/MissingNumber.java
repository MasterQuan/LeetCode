package com.quan.array;

/**
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。
 * 你有办法在O(n)时间内完成吗？
 *
 * 注意：本题相对书上原题稍作改动
 *
 * 示例 1：
 *
 * 输入：[3,0,1]
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] noMissing = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            noMissing[nums[i]] = true;
        }
        for (int i = 0; i < noMissing.length; i++) {
            if (!noMissing[i]) return i;
        }
        return -1;
    }


    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * 示例 1:
     * 输入: [0,1,3]
     * 输出: 2
     *
     * 示例2:
     * 输入: [0,1,2,3,4,5,6,7,9]
     * 输出: 8
     *
     * 限制：
     * 1 <= 数组长度 <= 10000
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] != mid) { right = mid; }
            else { left = mid + 1;}
        }
        // 如果从0 ~ n - 1都不缺值, 则缺少的是n
        return left == nums.length - 1 && nums[left] == left ? left + 1 : left;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3};
        System.out.println(new MissingNumber().missingNumber2(nums));
    }

}
