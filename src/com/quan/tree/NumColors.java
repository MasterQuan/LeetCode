package com.quan.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
 * 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
 *
 */
public class NumColors {
    int count = 0;
    public int numColor(TreeNode root) {
        boolean[] colors = new boolean[1001];
        collect(root, colors);
        return count;
    }
    private void collect(TreeNode root, boolean[] colors){
        if (root == null) return;
        if (!colors[root.val]){
            colors[root.val] = true;
            count++;
        }
        collect(root.left, colors);
        collect(root.right, colors);
    }
}
