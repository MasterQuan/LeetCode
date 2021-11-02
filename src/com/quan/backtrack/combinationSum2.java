package com.quan.backtrack;

import java.util.*;

/**
 * 给定一个数组candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 *
 */
public class combinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        int sum = 0;
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        //加标志数组，用来辅助判断同层节点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        backtracking(candidates,
                sum,
                target,
                0,
                flag,
                results,
                deque);
        return results;
    }

    public void backtracking(int[] candidates, int sum, int target, int index,
                             boolean[] flag, List<List<Integer>> results, Deque<Integer> deque) {
        if (sum == target) {
            results.add(new ArrayList(deque));
            return;
        }
        for (int i = index; i < candidates.length && candidates[i] + sum <= target; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += candidates[i];
            deque.push(candidates[i]);
            //每个节点仅能选择一次，所以从下一位开始
            backtracking(candidates,
                    sum,
                    target,
                    i + 1,
                    flag,
                    results,
                    deque);
            int temp = deque.pop();
            flag[i] = false;
            sum -= temp;
        }
    }
}
