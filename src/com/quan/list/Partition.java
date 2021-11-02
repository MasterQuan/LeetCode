package com.quan.list;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你不需要保留每个分区中各节点的初始相对位置。
 *
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 */
public class Partition {
    public ListNode partition1(ListNode head, int x) {
        if (null == head || head.next == null) return head;

        ListNode before = head;
        ListNode after = head;
        while( null != head){
            ListNode next = head.next;
            if (head.val < x){
                head.next = before;
                before = head;
            }else {
                after.next = head;
                after = head;
            }
            head = next;
        }
        after.next = null;
        return before;
    }

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
     * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * 示例 1：
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     *
     * 示例 2：
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        if (null == head || head.next == null) return head;
        ListNode before = new ListNode(-1);
        ListNode after = new ListNode(-1);
        ListNode head1 = before;
        ListNode head2 = after;
        while( null != head){
            if (head.val < x){
                head1.next = head;
                head = head.next;
                head1 = head1.next;
                head1.next = null;
            }else {
                head2.next = head;
                head = head.next;
                head2 = head2.next;
                head2.next = null;
            }
        }
        head1.next = after.next;
        return before.next;
    }
}
