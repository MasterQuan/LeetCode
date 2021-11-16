package com.quan.list;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) return head;
        ListNode pre = new ListNode();
        ListNode left = head, right = head;
        ListNode cur = head;
        while (right != null){
            int i = 1;
            for (; i < k && right != null; i++) {
                right = right.next;
            }
            if (i == k){
                pre.next = left;
            }
        }
        return null;
    }
}
