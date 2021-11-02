package com.quan.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> visited = new LinkedList<>();
        if (nums.length == 0) return result;
        backtrack(nums, visited, result);
        return result;
    }
    public void backtrack(int[] nums, LinkedList<Integer> visited, List<List<Integer>> result) {
        if (visited.size() == nums.length) {
            result.add(new ArrayList<>(visited));
            return;
        }
        for (int i =0; i < nums.length; i++) {
            // if visited, skip
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            backtrack(nums, visited, result);
            visited.removeLast();
        }
    }
}
