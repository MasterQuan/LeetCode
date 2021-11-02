package com.quan.list;

public class DeleteNode {

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     *
     * 现有一个链表 head = [4,5,1,9]，它可以表示为:
     *
     * 示例 1：
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为5的第二个节点，那么在调用了你的函数之后，
     * 该链表应变为 4 -> 1 -> 9.
     *
     * 示例 2：
     * 输入：head = [4,5,1,9], node = 1
     * 输出：[4,5,9]
     * 解释：给定你链表中值为1的第三个节点，那么在调用了你的函数之后，
     * 该链表应变为 4 -> 5 -> 9.
     *
     * 提示：
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node.next == null){
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     *
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，
     * 该链表应变为 4 -> 1 -> 9.
     *
     * 示例 2:
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，
     * 该链表应变为 4 -> 5 -> 9.
     *
     * 说明：
     * 题目保证链表中节点的值互不相同
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) return head;
        if (head.val == val) return head.next;

        ListNode p = head;
        while ( p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;break;
            }else {
                p = p.next;
            }
        }
        return head;
    }

    public ListNode deleteNodeWithRepeat(ListNode head, int val) {
        if (null == head) return head;

        ListNode p = head;
        while ( p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        if (head.val == val) head =  head.next;
        return head;
    }
}
