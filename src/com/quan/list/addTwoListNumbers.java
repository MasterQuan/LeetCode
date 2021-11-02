package com.quan.list;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 */
public class addTwoListNumbers {

    /**
     * 解法一，反转链表，然后求和。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        return reverseList(addTwoNumbers(reverseList(l1), reverseList(l2), 0));
    }

    private ListNode reverseList(ListNode head) {
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
    /**
     * 解法二，用栈存储。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0, sum = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            sum = stack1.pop() + stack2.pop() + carry;
            carry = sum / 10;
            res.val = sum % 10;
            ListNode node = new ListNode();
            node.next = res;
            res = node;
        }
        while (!stack1.isEmpty()){
            sum = stack1.pop() + carry;
            carry = sum / 10;
            res.val = sum % 10;
            ListNode node = new ListNode();
            node.next = res;
            res = node;
        }
        while (!stack2.isEmpty()){
            sum = stack2.pop() + carry;
            carry = sum / 10;
            res.val = sum % 10;
            ListNode node = new ListNode();
            node.next = res;
            res = node;
        }
        if (carry == 1){
            res.val = carry;
        }else res = res.next;

        return res;
    }
}
