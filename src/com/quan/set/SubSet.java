package com.quan.set;

import java.util.LinkedList;
import java.util.List;

public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        subsets.add(new LinkedList<Integer>());

        if (nums == null || nums.length == 0) return subsets;
        for (int i = 0; i < nums.length; i++) {
            subsets(subsets, nums[i]);
        }
        return subsets;
    }
    private void subsets(List<List<Integer>> list, int num){
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<Integer> tmp = new LinkedList<>();
            tmp.addAll(list.get(i));
            tmp.add(num);
            list.add(tmp);
        }
    }
}
