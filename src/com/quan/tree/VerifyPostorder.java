package com.quan.tree;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1) return true;
        int root = postorder[postorder.length - 1];
        int i = 0;
        for (; i < postorder.length; i++) {
            if (postorder[i] >= root){
                break;
            }
        }
        for (int j = i; j < postorder.length; j++) {
            if (postorder[j] < root) return false;
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, i))
                && verifyPostorder(Arrays.copyOfRange(postorder, i ,postorder.length - 1));
    }
}
