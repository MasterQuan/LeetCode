package com.quan.list;

public class ReverseList {
    /**
     * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
     *
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：[2,1]
     *
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
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

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * 限制：
     * 0 <= 链表长度 <= 10000
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (null == head){
            return new int[]{};
        }else {
            int size = 1;
            ListNode new_head = head;
            while (head.next != null){
                size++;
                ListNode p = head.next;
                head.next = head.next.next;
                p.next = new_head;
                new_head = p;
            }
            int[] values = new int[size];
            int i = 0;
            while (new_head != null){
                values[i] = new_head.val;
                new_head = new_head.next;
                i++;
            }
            return values;
        }
    }
}
