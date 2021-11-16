package com.quan.dynamic_programming;

import java.util.HashMap;

public class longestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1, pre, len;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a:arr) {
            pre = a - difference;
            len = map.containsKey(pre) ? map.get(pre) + 1 : 1;
            map.put(a, len);
            max = Math.max(max, len);
        }
        return max;
    }
}
