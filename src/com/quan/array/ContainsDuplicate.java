package com.quan.array;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (null == nums || nums.length <= 1){
            return false;
        }else {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)){
                    return true;
                }else set.add(num);
            }
            return false;
        }
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if (null == nums || nums.length <= 1){
            return -1;
        }else {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)){
                    return num;
                }else set.add(num);
            }
            return -1;
        }
    }


    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     *
     * @param nums
     * @return
     */
    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[(i+1) % nums.length]) return nums[i];
        }
        return nums[0] == nums[2] ? nums[0]:nums[1];
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (null == nums || nums.length <2 || k < 1) {
            return false;
        }else {
            Set<Integer> set = new HashSet<>();

            int left = 0;
            int right = k >= nums.length ? nums.length - 1 : k;
            for (int i = left; i <= right; i++) {
                if (set.contains(nums[i])){
                    return true;
                }else {
                    set.add(nums[i]);
                }
            }

            while (right < nums.length - 1){
                set.remove(nums[left]);
                right++;
                left++;
                if (set.contains(nums[right])){
                    return true;
                }else {
                    set.add(nums[right]);
                }
            }
        }
        return false;
    }
}
