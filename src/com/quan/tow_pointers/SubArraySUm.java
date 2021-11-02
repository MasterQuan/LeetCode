package com.quan.tow_pointers;

public class SubArraySUm {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }

        int count = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] == k) count++;
            for (int l = i + 1; l < sums.length; l++) {
                if (sums[l] - sums[i] == k){
                    count++;
                }
            }
        }
        return count;
    }
}
