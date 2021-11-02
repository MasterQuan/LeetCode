package com.quan.list;

/**
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
 * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，
 * 使所有结点出现在单级双链表中。
 *
 */
public class Flatten {
    public Node flatten(Node head) {
        Node node = head;
        while (node != null){
            if (node.child != null){
                flatten(node, node.next);
            }else node = node.next;
        }
        return head;
    }

    private void flatten(Node node, Node next) {
        //将child变成直接后继
        Node child = node.child;
        //去除child
        node.child = null;
        node.next = child;
        child.prev = node;
        while (node.next != null){
            node = node.next;
            if (node.child != null){
                flatten(node, node.next);
            }
        }
        //拼接上级后继
        if (next != null){
            node.next = next;
            next.prev = node;
        }
    }
}
