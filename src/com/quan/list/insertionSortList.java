package com.quan.list;

public class insertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        new insertionSortList().insertionSortList(head);
    }
    /**
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode input = head.next;
        head.next = null;
        while (input != null){
            ListNode p = prev;
            while (p.next != null){
                if (input.val <= p.next.val){
                    ListNode q = p.next;
                    p.next = input;
                    input = input.next;
                    p.next.next = q;
                    p = p.next;
                    break;
                }else {
                    p = p.next;
                }
            }
            if (p.next == null){
                p.next = input;
                input = input.next;
                p.next.next = null;
            }
        }
        return prev.next;
    }
}
