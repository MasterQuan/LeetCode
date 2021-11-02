package com.quan.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {

        int bottomLeft = root.val;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(null);
        nodes.offer(root);
        while (!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            while (node != null){
                if (node.left != null){
                    nodes.offer(node.left);
                }
                if(node.right != null){
                    nodes.offer(node.right);
                }
                node = nodes.poll();
            }
            if (node == null && !nodes.isEmpty()){
                bottomLeft = nodes.peek().val;
                nodes.offer(null);
            }
        }
        return bottomLeft;
    }

}
