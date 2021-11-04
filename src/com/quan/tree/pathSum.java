package com.quan.tree;

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
}


