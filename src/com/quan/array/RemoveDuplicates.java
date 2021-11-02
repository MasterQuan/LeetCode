package com.quan.array;

public class RemoveDuplicates {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
     * 使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组
     * 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len;){
            if (nums[i-1] == nums[i]){
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
            }else {
                i++;
            }
        }
        return len;
    }

    public int removeDuplicates2(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int i = 0, j = 1;
        while (j < nums.length){
            if (nums[i] == nums[j]){
                j++;
            }else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }

    /**
     *给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) return 0;
        int i = 0, j = nums.length - 1;
        while (i <= j){
            if (nums[i] == val){
                if (nums[j] == val){
                    j--;
                }else {
                    nums[i] = nums[j];
                    j--;
                    i++;
                }
            }else {
                i++;
            }
        }
        return i;
    }

}
