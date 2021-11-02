package com.quan.list;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 *
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        //快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next, q = head;
        p = reverseList(p);
        slow.next = null;
        while (p != null){
            ListNode t = q.next;
            q.next = p;
            p = p.next;
            q.next.next = t;
            q = t;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (null == head){
            return head;
        }else {
            ListNode new_head = head;
            while (head.next != null){
                ListNode p = head.next;
                head.next = head.next.next;
                p.next = new_head;
                new_head = p;
            }
            return new_head;
        }
    }
}
