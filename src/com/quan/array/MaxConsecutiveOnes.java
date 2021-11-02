package com.quan.array;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums){
            if (num == 1){
                count++;
                max = count > max ? count : max;
            }else {
                count = 0;
                if (max > nums.length >> 1) return max;
            }
        }
        return max;
    }
}
