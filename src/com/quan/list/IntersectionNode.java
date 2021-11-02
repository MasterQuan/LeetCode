package com.quan.list;

import java.util.List;

public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersect = null;
        if ( headA == null || headB == null) return intersect;

        //获取A和B的长度；
        int lenA = 0;
        int lenB = 0;
        ListNode node = headA;
        while (node != null){
            lenA++;
            node = node.next;
        }
        node = headB;
        while(node != null){
            lenB++;
            node = node.next;
        }

        //长的链表先走多出来的一段
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (lenA > lenB){
            int dv = lenA - lenB;
            for (int i = 0; i < dv; i++) {
                nodeA = nodeA.next;
            }
        }else{
            int dv = lenB - lenA;
            for (int i = 0; i < dv; i++) {
                nodeB = nodeB.next;
            }
        }
        //两个链表一起往后走
        while (nodeA != null){
            if (nodeA == nodeB ){
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return  intersect;
    }
}
