package com.quan.array;

public class SearchInsert {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int pos = 0;
        while(left <= right){
            pos = (left + right) >> 1;
            if (nums[pos] == target){
                return pos;
            }else if (nums[pos] < target){
                left = pos + 1;
            }else {
                right = pos - 1;
            }
        }
        if (nums[pos] < target){
            pos++;
        }
        return pos;
    }
}
