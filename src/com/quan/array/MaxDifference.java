package com.quan.array;

public class MaxDifference {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int m_d = -1;

        for(int i = 1; i < nums.length; i++){
            m_d = m_d > nums[i] - min ? m_d : nums[i] - min;
            if (nums[i] < min){
                min = nums[i];
            }
        }

        return m_d == 0 ? -1 : m_d;
    }
}
