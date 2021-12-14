package com.quan.sort;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class minNumber {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length < 1) return new String();
        String[] values = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(values, (v1,v2)->(v1 + v2).compareTo(v2 + v1));
        StringBuilder sb = new StringBuilder();
        for (String v : values) {
            sb.append(v);
        }
        return sb.toString();
    }

}
