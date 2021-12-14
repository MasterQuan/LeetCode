package com.quan.tree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class TreeToDoublyList {
    Node head;  //head节点。
    Node pre;   //head的前一个节点，head.left = pre, pre.right = head。
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        //此时的pre应该是链表的最后一个节点，也是head的前一个节点
        head.left = pre;
        pre.right = head;
        return head;
    }
    private void dfs(Node cur){
        if (cur == null) return;
        //先转换左子树
        dfs(cur.left);
        //pre为null，证明head也为null,将cur复制给head
        if (pre == null) {
            head = cur;
        }else {
            //将cur变成pre的下一个节点
            pre.right = cur;
        }
        //cur节点前置指向pre
        cur.left = pre;
        //将pre变成cur，对cur的右子树进行dfs
        pre = cur;
        dfs(cur.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
