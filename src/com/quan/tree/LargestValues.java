package com.quan.tree;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null);
        long max = Long.MIN_VALUE;
        while (!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            if (node == null){
                ans.add((int)max);
                max = Long.MIN_VALUE;
                if (nodes.size() == 0){
                    break;
                }
                nodes.offer(null);
            }else {
                max = node.val > max ? node.val : max;
                if (node.left != null){
                    nodes.offer(node.left);
                }
                if(node.right != null){
                    nodes.offer(node.right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Long.MIN_VALUE < Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE > Integer.MAX_VALUE);
    }
}
