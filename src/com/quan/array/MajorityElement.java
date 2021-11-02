package com.quan.array;

public class MajorityElement {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于n/2的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 示例1：
     * 输入：[3,2,3]
     * 输出：3
     *
     * 示例2：
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1;i<nums.length;i++){
            if(nums[i] == maj){
                count++;
            }else{
                count--;
            }
            if (count == 0){
                maj = nums[i+1];
            }
        }
        return maj;
    }

    /**
     * 数组中占比超过一半的元素称之为主要元素。
     * 给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
     * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
     *
     * 示例 1：
     *
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     * 示例 2：
     *
     * 输入：[3,2]
     * 输出：-1
     * 示例 3：
     *
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        if (null == nums || nums.length < 1) return -1;

        int count = 1;
        int maj = nums[0];
        for (int i = 1;i<nums.length;i++){
            if(nums[i] == maj){
                count++;
            }else{
                count--;
            }
            if (count == 0){
                maj = nums[i+1 == nums.length ? 0 : i + 1];
            }
        }
        // 验证是不是众数
        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == maj) cnt++;
            if (cnt > nums.length / 2) return maj;
        }
        return -1;
    }

}
