package com.quan.list;

import com.quan.dynamic_programming.ClimbStairs;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) return null;

        ListNode h = new ListNode();
        h.next = head;
        ListNode fast = h, slow = h;

        for (int i = 0; i < n; i++) {
            if (null == fast.next) break;
            fast = fast.next;
        }
        while (null != fast.next){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return h.next;
    }
}
