package com.quan.tree;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cur = root;
    }

    public int next() {
        if (hasNext()) {
            TreeNode node = stack.pop();
            cur = node.right;
            return node.val;
        }
        return -1;
    }

    public boolean hasNext() {
        if (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
        }
        return !stack.isEmpty();
    }
}
