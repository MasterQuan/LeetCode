package com.quan.list;

/**
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //归并排序
        //将链表一分为二
        ListNode pre = head, slow = head, fast = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode head = new ListNode();
        //赋值头结点
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;
        while (null != l1){
            //判断 l2是否到头
            if (null == l2){
                cur.next = l1;
                return head;
            }

            if (l1.val < l2.val){
                cur = cur.next = l1;
                l1 = l1.next;
            }else{
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }
        //l1到头，将l2追加在后方
        cur.next = l2;
        return head;
    }
}
