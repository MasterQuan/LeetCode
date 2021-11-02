package com.quan.list;

public class KThFromEnd {

    public int kthToLast(ListNode head, int k) {
        if (null == head) return 0;

        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (null != fast.next){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public ListNode kthNodeToLast(ListNode head, int k) {
        if (null == head) return head;

        ListNode fast = head, slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (null != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
