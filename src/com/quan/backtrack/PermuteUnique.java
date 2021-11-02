package com.quan.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //存放结果
        List<List<Integer>> result = new LinkedList<>();
        //暂存结果
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used, path, result);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used, LinkedList path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树支重复使用
                path.add(nums[i]);
                backTrack(nums, used, path, result);
                path.removeLast();//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }
}
