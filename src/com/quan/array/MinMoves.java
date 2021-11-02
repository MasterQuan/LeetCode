package com.quan.array;

public class MinMoves {
    public int minMoves(int[] nums) {
        int count = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = nums[i] < min ? nums[i] : min;
        }
        for (int num : nums){
            count += num - min;
        }
        return count;
    }
}
