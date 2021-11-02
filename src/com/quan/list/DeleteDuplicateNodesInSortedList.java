package com.quan.list;

public class DeleteDuplicateNodesInSortedList {
    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     *
     * 返回同样按升序排列的结果链表。
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (null == head || head.next == null) return head;

        ListNode p, q;
        p = head;
        q = p.next;
        while(q != null){
            if (p.val == q.val){
                q = q.next;
                p.next = q;
            }else {
                p = q;
                q = q.next;
            }
        }
        return head;
    }

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
     * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
     *
     * 返回同样按升序排列的结果链表。
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public ListNode deleteDuplicates2(ListNode head) {
        if (null == head || head.next == null) return head;

        ListNode p, q, l, tmp = null;
        ListNode r = new ListNode();
        l = r;
        r.next = head;
        p = head;
        q = p.next;
        while(q != null){
            if (p.val == q.val){                           //判断p与q是否相同
                tmp = p;
                r.next = q;
                p = p.next;
                q = q.next;
            }else if (tmp != null && tmp.val == p.val){    //判断tmp与p节点是否相同
                r.next = q;
                p = p.next;
                q = q.next;
            }else{
                p = p.next;
                q = q.next;
                r = r.next;
            }
        }
        if (tmp != null && tmp.val == p.val){    //判断tmp与p节点是否相同
            r.next = q;
        }

        return l.next;
    }
}
