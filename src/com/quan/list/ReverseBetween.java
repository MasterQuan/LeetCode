package com.quan.list;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode vnode = new ListNode();
        vnode.next = head;
        ListNode l = vnode, r = vnode;

        for (int i = 1; i <= right; i++){
            if (i < left){
                l = l.next;
            }
            if (i <= right){
                r = r.next;
            }
        }

        //保留前置节点的引用
        ListNode prel = l;
        //l下移到真正需要反转的起点
        l = l.next;
        //反转后链表的头节点
        ListNode nh = l;
        ListNode end = r.next;
        while (l.next != end){
            ListNode h = l.next;
            l.next = l.next.next;
            h.next = nh;
            nh = h;
        }

        prel.next = nh;
        return vnode.next;
    }
}
