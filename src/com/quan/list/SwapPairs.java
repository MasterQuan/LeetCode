package com.quan.list;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head.print(new SwapPairs().swapPairs(head));
//        new SwapPairs().swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        if (null == head || head.next == null) return head;
        ListNode r = head.next;
        ListNode p = new ListNode();
        while ( null != head && null != head.next){
            p.next = head.next;
            head.next = head.next.next;
            p.next.next = head;
            head = head.next;
            p = p.next.next;
        }
        return r;
    }

}
