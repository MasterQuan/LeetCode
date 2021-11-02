package com.quan.array;

import java.util.*;
import java.util.function.Consumer;

public class topKFrequent {
    /**
     * 给定一个整数数组 nums 和一个整数 k，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
     *
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            int ct = map.containsKey(num) ? map.get(num) : 0;
            map.put(num, ct+1);
        }
        List<Integer> res = new LinkedList<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Integer> comparingByValue().reversed())
                .limit(k)
                .forEachOrdered(e -> res.add(e.getKey()));
        int i = 0;
        for ( Integer r : res) {
            ans[i++] = r;
        }
        return ans;
    }
}
