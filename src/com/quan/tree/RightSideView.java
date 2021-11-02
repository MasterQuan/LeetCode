package com.quan.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(null);
        nodes.offer(root);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            while (node != null){
                if(node.right != null){
                    nodes.offer(node.right);
                }
                if (node.left != null){
                    nodes.offer(node.left);
                }
                node = nodes.poll();
            }
            if (node == null && !nodes.isEmpty()){
                ans.add(nodes.peek().val);
                nodes.offer(null);
            }
        }

        return ans;
    }
}
