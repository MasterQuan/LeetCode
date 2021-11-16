package com.quan.tree;

import javax.imageio.stream.ImageInputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class ProblemsOnNode {
    /**
     * 给定一个 N 叉树，找到其最大深度。
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(maxDepth(child), depth) + 1;
        }
        return depth;
    }


    /**
     * 给定一个 N 叉树，返回其节点值的 前序遍历 。
     * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> path = new LinkedList<>();
        preorder(root, path);
        return path;
    }

    private void preorder(Node root, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        for (Node child : root.children) {
            preorder(child, path);
        }
    }

    /**
     * 给定一个 N 叉树，返回其节点值的 后序遍历 。
     * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> path = new LinkedList<>();
        postorder(root, path);
        return path;
    }

    private void postorder(Node root, List<Integer> path) {
        if (root == null) return;
        for (Node child : root.children) {
            postorder(child, path);
        }
        path.add(root.val);
    }


}
