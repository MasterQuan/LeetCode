package com.quan.array;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new LinkedList<>();
        int left = 0, right = 0;
        while (right < nums.length){
            if(right + 1 >= nums.length){
                summary.add( left == right ? new StringBuilder().append(nums[left]).toString()
                        : new StringBuilder().append(nums[left]).append("->").append(nums[right]).toString());
                break;
            }
            if (nums[right + 1] > 1 + nums[right]){
                summary.add( left == right ? new StringBuilder().append(nums[left]).toString()
                        : new StringBuilder().append(nums[left]).append("->").append(nums[right]).toString());
                right++;
                left = right;
            }else {
                right++;
            }
        }
        return summary;
    }
}
