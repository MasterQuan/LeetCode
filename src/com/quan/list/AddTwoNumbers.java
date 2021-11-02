package com.quan.list;


/**
 * 给你两个非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 */
public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          return addTwoNumbers(l1,l2,0);
    }

    private ListNode addTwoNumbers(ListNode a, ListNode b, int carry){
        if(a == null){
            if(carry == 0)
                return b;
            if(b == null){
                return new ListNode(carry);
            }
            int sum = b.val + carry;
            ListNode result = new ListNode(sum % 10);
            carry = sum / 10;
            result.next = addTwoNumbers(a, b.next, carry);
            return result;
        }else{
            if(b == null){
                if(carry == 0)
                    return a;
                int sum = a.val + carry;
                ListNode result = new ListNode(sum % 10);
                carry = sum / 10;
                result.next = addTwoNumbers(a.next, b, carry);
                return result;
            }
            int sum = a.val + carry + b.val;
            ListNode result = new ListNode(sum % 10);
            carry = sum / 10;
            result.next = addTwoNumbers(a.next, b.next, carry);
            return result;
        }
    }
}
