package com.quan.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (null == root) return lists;
        LinkedList<TreeNode> fathers = new LinkedList<>();
        fathers.add(root);
        fathers.add(null);
        List<Integer> values = new LinkedList<>();

        int flag = 0;//0表示正序，1表示逆序存储
        TreeNode head;
        while (fathers.size() != 0){
            head = fathers.removeFirst();

            if (head == null){
                lists.add(values);
                values = new LinkedList<>();

                if (fathers.size() == 0) return lists;
                flag ^= 1;
                fathers.add(null);
            }else {
                if (head.left != null) fathers.add(head.left);
                if (head.right != null) fathers.add(head.right);

                //正序
                if (flag == 0){
                    values.add(head.val);
                }else {
                    values.add(0,head.val);
                }
            }
        }
        return lists;
    }
}
