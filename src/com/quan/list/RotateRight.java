package com.quan.list;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || null == head.next || k < 1) return head;

        //计算出整个链表的长度
        ListNode p = head;
        int len = 0;
        while (p != null){
            len++;
            p = p.next;
        }

        //如果异动是链表长度的整数倍，直接返回当前链表
        int mov = k % len;
        if (0 == mov) return head;

        ListNode start = head;
        ListNode end = head;
        for (int i = 1; i < len - mov; i++) {
            end = end.next;
        }
        start = end.next;       //设置为链表头
        end.next = null;             //设置为链表末尾。
        p = start;
        while (p.next != null){ //拼接链表
            p = p.next;
        }
        p.next = head;
        return start;
    }
}
