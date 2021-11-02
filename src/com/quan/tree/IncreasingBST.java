package com.quan.tree;

public class IncreasingBST {
    private TreeNode pre = new TreeNode(), node = pre;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return pre.right;
    }

    //根据二叉树的左小右大的性质
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        // 添加节点
        node.right = new TreeNode(root.val);
        // 继续向右节点添加
        node = node.right;
        dfs(root.right);
    }
}