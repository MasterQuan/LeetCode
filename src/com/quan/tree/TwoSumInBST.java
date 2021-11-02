package com.quan.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TwoSumInBST {
    /**
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> orders = new ArrayList<>();
        inOrder(root, orders);
        int l = 0, r = orders.size() - 1;
        while (l < r){
            int s = orders.get(l) + orders.get(r);
            if (s == k){
                return true;
            }else if(s > k){
                r--;
            }else l++;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> orders){
        if (root == null) return;
        inOrder(root.left, orders);
        orders.add(root.val);
        inOrder(root.right, orders);
    }
}
