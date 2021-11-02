package com.quan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        //计算前缀和，并用Map保存。
        int max_len = 0, sum = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]== 0 ? -1 : 1;
            if (hash.containsKey(sum)){
                max_len = max_len <= i - hash.get(sum) ? i - hash.get(sum) : max_len;
            }else {
                hash.put(sum, i);
            }
        }
        return max_len;
    }
}
