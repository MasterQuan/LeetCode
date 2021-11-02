package com.quan.list;

import java.util.List;

public class SwapNodes {
    /**
     * 给你链表的头节点 head 和一个整数 k 。
     * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode swap1 = fast;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode swap2 = slow;
        int tmp = swap2.val;
        swap2.val = swap1.val;
        swap1.val = tmp;
        return head;
    }
}
