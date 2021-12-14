package com.quan.array;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        //原地复制链表
        Node nHead = head, cur = head;
        while (cur != null){
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }

        //改写新节点的random节点
        nHead = head.next;
        Node cur0 = head, cur1;
        while (cur0 != null){
            cur1 = cur0.next;
            if (cur0.random == null){
                cur1.random = null;
            }else cur1.random = cur0.random.next;
            cur0 = cur0.next.next;
        }

        //将两个链表拆开
        cur0 = head;
        cur1 = head.next;
        while (cur0 != null && cur1 != null && cur1.next != null){
            cur0.next = cur1.next;
            cur0 = cur0.next;
            cur1.next = cur1.next.next;
            cur1 = cur1.next;
        }
        cur0.next = null;
        return nHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

