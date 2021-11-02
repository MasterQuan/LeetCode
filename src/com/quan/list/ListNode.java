package com.quan.list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print(ListNode node){
        String s = "[";
        while (node != null){
            s += node.val;
            s += ",";
            node = node.next;
        }
        s += "]";
        System.out.println(s);
    }
}
