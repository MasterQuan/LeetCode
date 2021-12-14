package com.quan.tree;

import java.util.Arrays;

public class BuildBinaryTree {
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) return null;

        int rn = preorder[0];
        int pos = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rn){
                pos = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rn);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,pos + 1), Arrays.copyOfRange(inorder,0,pos));
        root.right = buildTree(Arrays.copyOfRange(preorder,1 + pos,length), Arrays.copyOfRange(inorder,pos + 1,length));
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;

        int rootVal = postorder[len - 1], rootIndex = 0;
        for (int i = 0; i < len; i++) {
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootIndex),
                Arrays.copyOfRange(postorder,0,rootIndex));
        root.right = buildTree(Arrays.copyOfRange(inorder, rootIndex + 1, len),
                Arrays.copyOfRange(postorder,rootIndex,len - 1));
        return root;
    }
}
