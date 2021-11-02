package com.quan.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        //去重
        for (int num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        for (Integer num : numsSet) {
            if (numsSet.remove(num)) {
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;
                int current = num - 1;
                while (numsSet.remove(current)){
                    current--;
                }
                currentLongest += (num -1 - current);
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
                current = num + 1;
                while(numsSet.remove(current)){
                    current++;
                }
                currentLongest += (current - 1 - num);
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }
}
