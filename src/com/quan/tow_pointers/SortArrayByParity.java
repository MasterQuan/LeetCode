package com.quan.tow_pointers;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null) return nums;
        int left = 0, right = nums.length - 1;
        while (left < right){
            if ((nums[left] & 1) != 1){
                left++;
            } else if ((nums[right] & 1) != 0){
                right--;
            }else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return nums;
    }
    public int[] sortArrayByParity2(int[] nums) {
        if (nums == null || (nums.length & 1) != 0) return nums;
        int even = 0, odd = 1;
        int tmp;
        while (odd <= nums.length - 1 && even < nums.length){
            if ((nums[even] & 1) != 1){
                even += 2;
            }else if ((nums[odd] & 1) != 0){
                odd += 2;
            }else {
                tmp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = tmp;
                odd += 2;
                even += 2;
            }
        }
        return nums;
    }
}
