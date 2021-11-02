package com.quan.tow_pointers;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        int mid, pos = -1, l = 0, r = nums.length - 1;
        while (l <= r){
            mid = (l + r) >> 1;
            if (nums[mid] == target){
                pos = mid;
                break;
            }else if (nums[mid] > target){
                l = mid + 1;
            }else{
                r = r - 1;
            }
        }

        if (pos == -1) return range;
        boolean stopLeft = false, stopRight = false;
        l = pos;
        r = pos;
        while (stopLeft == false || stopRight == false){
            if (!stopLeft && nums[l] == target){
                l--;
            }
            if (!stopRight && nums[r] == target){
                r++;
            }
            if (l < 0 || nums[l] != target){stopLeft = true;}
            if (r == nums.length || nums[r] != target){stopRight = true;}
        }
        range[0] = l + 1;
        range[1] = r - 1;
        return range;
    }
}
