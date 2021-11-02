package com.quan.dynamic_programming;

public class CanJump {
    /**
     * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     *
     * 示例1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        if (max >= nums.length - 1) return true;
        for (int i = 0; i < nums.length - 1 && max >= i; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true;
        }
        return false;
    }

    /**
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     *
     * 示例 1:
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = 0;
        int i = 1, pos = 0, max = nums[pos] + pos, new_max = nums[0];

        while (i <= max && i < nums.length){
            min[i] = pos + 1;
            if(max >= nums.length - 1){
                min[nums.length - 1] = min[i];
                break;
            }

            new_max = Math.max(new_max, nums[i] + i);
            if (new_max >= nums.length - 1){
                min[nums.length - 1] = min[i] + 1;
                break;
            }

            if (i == max){
                max = new_max;
                pos = min[i];
            }
            i++;
        }
        return min[nums.length - 1];
    }
}
