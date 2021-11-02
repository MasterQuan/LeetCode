package com.quan.list;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeList {


    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) return true;

        //快慢指针找中点
        ListNode fast  = head, slow = head;
        while (null != fast && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        // 前后两段比较是否一致
        ListNode node = head;
        while (pre != null) {
            if (pre.val != node.val) {
                return false;
            }
            pre = pre.next;
            node = node.next;
        }

        return true;
    }
}
