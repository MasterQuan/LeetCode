package com.quan.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if (node != null){
                sb.append(node.val).append(' ');
                queue.add(node.left);
                queue.add(node.right);
            }else {
                sb.append("N").append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        if (nodes.length < 1 || nodes[0].equals("N") ) return null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            i++;
            if (i < nodes.length && !nodes[i].equals("N")){
                TreeNode left = new TreeNode(Integer.valueOf(nodes[i]));
                node.left = left;
                queue.add(left);
            }
            i++;
            if (i < nodes.length && !nodes[i].equals("N")){
                TreeNode right = new TreeNode(Integer.valueOf(nodes[i]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));