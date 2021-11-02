package com.quan.tree;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator2 {

    List<Integer> tree;
    int pos = -1;

    public BSTIterator2(TreeNode root) {
        tree = new ArrayList<>();
        inorderTraversal(root, tree);
    }

    public int next() {
        if (hasNext()){
            pos++;
        }
        return tree.get(pos);
    }

    public boolean hasNext() {
        if (pos + 1 < tree.size()){
            return true;
        }
        return false;
    }

    private void inorderTraversal(TreeNode root, List elements) {
        if (null != root) {
            inorderTraversal(root.left, elements);
            elements.add(root.val);
            inorderTraversal(root.right, elements);
        }
    }
}
