package com.quan.tow_pointers;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 */
public class sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        int left = 0, right = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                right = i;
                break;
            }
        }
        left = right - 1;
        int j = 0;
        while (left >= 0 && right < nums.length ) {
            int sl = nums[left] * nums[left], sr = nums[right] * nums[right];
            if (sl < sr) {
                squares[j++] = sl;
                left--;
            } else {
                squares[j++] = sr;
                right++;
            }
        }
        while (left >= 0) {
            squares[j++] = nums[left] * nums[left];
            left--;
        }
        while (right < nums.length) {
            squares[j++] = nums[right] * nums[right];
            right++;
        }
        return squares;
    }
}
