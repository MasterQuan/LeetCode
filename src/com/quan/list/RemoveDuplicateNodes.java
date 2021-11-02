package com.quan.list;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateNodes {

    public static void main(String[] args) {

    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return  head;

        boolean[] flags = new boolean[20001];
        ListNode noDup = new ListNode(head.val);
        ListNode cn = noDup;
        flags[head.val] = true;
        while (head != null){
            if (!flags[head.val]){
                flags[head.val] = true;
                ListNode n = new ListNode(head.val);
                cn.next = n;
                cn = n;
                head = head.next;
            }else {
                head = head.next;
            }
        }
        return noDup;
    }
}
