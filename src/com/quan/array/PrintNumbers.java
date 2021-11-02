package com.quan.array;

public class PrintNumbers {
    public int[] printNumbers(int n) {
        int[] nums = new int[0];
        if(n < 1) return nums;
        nums = new int[(int)Math.pow(10, n) - 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
