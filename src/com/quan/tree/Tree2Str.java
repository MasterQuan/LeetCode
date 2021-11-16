package com.quan.tree;

public class Tree2Str {
    /**
     * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     * 空节点则用一对空括号 "()" 表示。
     * 而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if (root == null) return new String();
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.left != null){
            sb.append('(').append(tree2str(root.left)).append(')');
            if (root.right != null){
                sb.append('(').append(tree2str(root.right)).append(')');
            }
        }else {
            if (root.right != null){
                sb.append("()").append('(').append(tree2str(root.right)).append(')');
            }
        }
        return sb.toString();
    }
}
