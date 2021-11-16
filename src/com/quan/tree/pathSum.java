package com.quan.tree;

import java.util.List;

/**
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 */
public class pathSum {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        reverse(root, targetSum);
        return count;
    }
    public void reverse(TreeNode root, int targetSum){
        if (root == null) return ;
        sum(root, targetSum);
        reverse(root.right, targetSum);
        reverse(root.left, targetSum);
    }
    public void sum(TreeNode root, int targetSum){
        if (root == null) return ;
        if (targetSum == root.val) count ++;
        sum(root.right, targetSum - root.val);
        sum(root.left, targetSum - root.val);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {

        return null;
    }

}


