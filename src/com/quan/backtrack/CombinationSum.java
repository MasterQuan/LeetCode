package com.quan.backtrack;

import java.util.*;

/**
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，
 * 找出candidates中所有可以使数字和为目标数target的唯一组合。
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 *
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res, new LinkedList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res,
                             LinkedList<Integer> path,
                             int[] candidates,
                             int target,
                             int sum,
                             int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            // 剪枝策略：sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.removeLast();// 回溯，移除路径 path 最后一个元素
        }
    }
}
