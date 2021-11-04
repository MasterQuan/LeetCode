package com.quan.tree;

import java.util.LinkedList;

/**
 *
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 *
 */
public class sumNumbers {
    private int sumNodes = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumNumbers(root, 0);
        return sumNodes;
    }
    private void sumNumbers(TreeNode root, int sum){
        sum = sum * 10 + root.val;
        if (root.left != null) sumNumbers(root.left, sum);
        if (root.right != null) sumNumbers(root.right, sum);
        if (root.right == null && root.left == null){
            sumNodes += sum;
        }
    }
}
