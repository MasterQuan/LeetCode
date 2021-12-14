package com.quan.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class PathSum2 {
    private List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        sum(root, targetSum, path);
        return ans;
    }

    private void sum(TreeNode root, int sum, LinkedList<Integer> path){
        if (root == null) return;
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null){
            ans.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        sum -= root.val;
        sum(root.left, sum, path);
        sum(root.right, sum, path);
        path.removeLast();
    }
}
