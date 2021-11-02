package com.quan.list;

public class MergeLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        int step = 1;
        while (step < lists.length) {
            int nextStep = step << 1;// step*2
            // 相邻2、4、8...
            for (int i = 0; i+step < lists.length; i += nextStep) {
                lists[i] = mergeTwoLists(lists[i], lists[i+step]);// 合并2条链表
            }
            step = nextStep;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode head = new ListNode();
        //赋值头结点
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;
        while (null != l1){
            //判断 l2是否到头
            if (null == l2){
                cur.next = l1;
                return head;
            }

            if (l1.val < l2.val){
                cur = cur.next = l1;
                l1 = l1.next;
            }else{
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }
        //l1到头，将l2追加在后方
        cur.next = l2;

        return head;
    }

}
