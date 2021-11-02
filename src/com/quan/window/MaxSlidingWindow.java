package com.quan.window;

import java.util.Arrays;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 1)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length < 1){
            return new int[0];
        }

        //滑动窗口，将最大值记入结果集中。
        int[] max_windows = new int[nums.length - k + 1];
        for (int start = 0, end = k - 1, max = nums[0], pos = -1;
             end < nums.length;
             start++, end++) {
            if (pos < start){
                max = nums[start];
                for (int i = start; i <= end; i++) {
                    if (max <= nums[i]){
                        max = nums[i];
                        pos = i;
                    };
                }
            }else {
                if (max <= nums[end]){
                    max = nums[end];
                    pos = end;
                };
            }
            max_windows[start] = max;
        }
        return max_windows;
    }
}
