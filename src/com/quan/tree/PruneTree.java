package com.quan.tree;

public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if (isZeroTree(root)){
            root = null;
        }else {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        }
        return root;
    }
    private boolean isZeroTree(TreeNode root){
        if (root == null) return true;
        return root.val == 0 && isZeroTree(root.left) && isZeroTree(root.right) ? true : false;
    }

    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) return root;
        if(root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }
}
