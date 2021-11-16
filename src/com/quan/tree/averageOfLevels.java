package com.quan.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 */
public class averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        if(root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        queue.add(null);
        double sum = 0.0;
        int count = 0;
        TreeNode cur;
        while (!queue.isEmpty()){
            cur = queue.pop();
            if (cur != null){
                sum += cur.val;
                count++;
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }else {
                ans.add(sum / count);
                sum = 0.0;
                count = 0;
                if (!queue.isEmpty()) queue.add(null);
            }
        }
        return ans;
    }
}
