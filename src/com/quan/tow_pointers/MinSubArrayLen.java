package com.quan.tow_pointers;

public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int min_len = nums.length, len;
        int sum = 0;
        boolean has = false;
        for (int i = 0, j = 0; i <= j && j < nums.length; ) {
            if (sum < target){
                sum += nums[j++];
            }
            while (sum >= target){
                has = true;
                len = j - i;
                min_len = min_len > len ? len : min_len;
                sum -= nums[i++];
            }
        }
        if (has) return min_len;
        return 0;
    }


}
