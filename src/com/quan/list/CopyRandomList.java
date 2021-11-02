package com.quan.list;

import java.util.HashMap;

public class CopyRandomList {
    public Node_Random copyRandomList(Node_Random head) {
        if (null == head){
            return null;
        }else {
            HashMap<Integer, Node> map = new HashMap<>();
            int pos = 0;
            Node_Random p = head;
            while (p != null){
                pos++;
            }
        }

        return null;
    }
}
class Node_Random {
    int val;
    Node next;
    Node random;

    public Node_Random(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
