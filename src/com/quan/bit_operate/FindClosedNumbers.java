package com.quan.bit_operate;

public class FindClosedNumbers {
    public int[] findClosedNumbers(int num) {
        int[] nums = new int[2];
        int c0 = 0, c1 = 0, tmp = num;
        while ((tmp & 1) ==1){
            c1++;
            tmp >>= 1;
        }
        while ((tmp & 1) == 0 && tmp != 0){
            c0++;
            tmp >>= 1;
        }
        nums[0] = num + (1 << c0) + (1 << (c1 - 1)) - 1;
        nums[1] = num - (1 << c1) - (1 << (c0 - 1)) + 1;
        return nums;
    }
}
