package com.quan.list;

public class Insert {
    public Node insert(Node head, int insertVal) {
        if (head == null){
            Node node = new Node(insertVal);
            head = node;
            head.next = head;
        }else {
            Node first = head;
            Node last = head;

            while (true){
                if (last.next.val < last.val){
                    first = last.next;
                    break;
                }else {
                    last = last.next;
                    if (last == head) break;
                }
            }
            if (last == first){
                Node node = new Node(insertVal);
                node.next = last.next;
                last.next = node;
            }else {
                if (insertVal <= first.val || insertVal >= last.val){
                    Node node = new Node(insertVal);
                    node.next = first;
                    last.next = node;
                }else {
                    while (first != last){
                        if (first.val < insertVal && first.next.val>= insertVal){
                            Node node = new Node(insertVal);
                            node.next = first.next;
                            first.next = node;
                            break;
                        }else first = first.next;
                    }
                }
            }
        }
        return head;
    }
}
