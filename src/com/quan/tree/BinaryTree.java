package com.quan.tree;


import com.quan.list.ListNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    /**
     * 现一个函数，检查二叉树是否平衡。在这个问题中，
     * 平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;

        int depthDiff = Math.abs(maxDepth(root.right) - maxDepth(root.left));
        if (depthDiff > 1) {
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }

    /**
     * 求一棵二叉树的高度，空树的高度默认为0
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点。
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (null == root) return 0;
        if (null == root.left && null == root.right) return 1;

        if (null == root.left) {
            return minDepth(root.right) + 1;
        } else if (null == root.right) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null == p && null != q) return false;
        if (null != p && null == q) return false;

        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 二叉树先序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> elements = new LinkedList<>();
        preorderTraversal(root, elements);
        return elements;
    }

    private void preorderTraversal(TreeNode root, List elements) {
        if (null != root) {
            elements.add(root.val);
            preorderTraversal(root.left, elements);
            preorderTraversal(root.right, elements);
        }
    }

    /**
     * 二叉树中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> elements = new LinkedList<>();
        inorderTraversal(root, elements);
        return elements;
    }

    private void inorderTraversal(TreeNode root, List elements) {
        if (null != root) {
            inorderTraversal(root.left, elements);
            elements.add(root.val);
            inorderTraversal(root.right, elements);
        }
    }

    /**
     * 二叉树后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> elements = new LinkedList<>();
        postorderTraversal(root, elements);
        return elements;
    }

    private void postorderTraversal(TreeNode root, List elements) {
        if (null != root) {
            postorderTraversal(root.left, elements);
            postorderTraversal(root.right, elements);
            elements.add(root.val);
        }
    }

    /**
     * 翻转一棵二叉树。
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) return root;

        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }

    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) return root;

        TreeNode node = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(node);
        return root;
    }


    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        root.left = invertTree(root.left);
        return isSameTree(root.left, root.right);
    }

    /**
     * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，
     * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
     * <p>
     * 叶子节点 是指没有子节点的节点。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) return false;
        targetSum -= root.val;
        if (0 == targetSum && null == root.left && null == root.right) return true;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     *     设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
     *     不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
     *
     * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     *     3
     *    / \
     *   5   1
     *  / \ / \
     * 6  2 0  8
     *   / \
     *  7   4
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 说明:
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) return null;
        if (p == q) return p;
        return ancestorHelper(root, p, q);
    }

    private TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        //判断p和q是否不在同一边。
        boolean ispLeft = covers(root.left, p);
        boolean isqLeft = covers(root.left, q);
        if (ispLeft != isqLeft) {
            return root;
        }

        TreeNode child = ispLeft ? root.left : root.right;
        return ancestorHelper(child, p, q);
    }

    /**
     * 判断节点target是否在树root中。
     *
     * @param root
     * @param target
     * @return
     */
    public boolean covers(TreeNode root, TreeNode target) {
        if (null == root) return false;
        if (root == target) return true;

        return covers(root.left, target) || covers(root.right, target);
    }

    /**
     * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
     * 叶子节点 是指没有子节点的节点。
     *
     * 示例 1：
     * 输入：root = [1,2,3,null,5]
     * 输出：["1->2->5","1->3"]
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        getPath(paths, root,new StringBuilder());
        return paths;
    }

    private void getPath(List<String> paths, TreeNode node, StringBuilder sb){
        if (null == node) return;
        if (null == node.left && null == node.right){
            paths.add(sb.append(node.val).toString());
        }
        sb.append(node.val).append("->");
        StringBuilder sb1 =  new StringBuilder(sb);
        StringBuilder sb2 = new StringBuilder(sb);
        getPath(paths, node.left, sb1);
        getPath(paths, node.right, sb2);
    }

    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。
     * tree 也可以看做它自身的一棵子树。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (null == subRoot) return true;
        if (null == root) return false;

        if (root.val == subRoot.val && isSameTree(root, subRoot)){
            return true;
        }return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (null == t2) return true;
        if (null == t1) return false;

        if (t1.val == t2.val && isSameTree(t1, t2)){
            return true;
        }return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }


    /**
     * 计算给定二叉树的所有左叶子之和。
     *
     * 示例 1：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> left_leafs = new LinkedList<>();
        sumOfLeftLeaves(root, left_leafs);
        int sum = 0;
        for (Integer i: left_leafs) {
            sum += i;
        }
        return sum;
    }

    private void sumOfLeftLeaves(TreeNode root, List<Integer> left_leafs){
        if (null == root) return;
        TreeNode left_node = root.left;
        if (null == left_node){
            sumOfLeftLeaves(root.right, left_leafs);
            return;
        }
        if (null == left_node.left && null == left_node.right){
            left_leafs.add(left_node.val);
            sumOfLeftLeaves(root.right, left_leafs);
            return;
        }
        sumOfLeftLeaves(root.left, left_leafs);
        sumOfLeftLeaves(root.right, left_leafs);
    }

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     * 例如:
     * 给定二叉树:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (null == root) return lists;

        List<TreeNode> father = new LinkedList<>();
        father.add(root);
        List<TreeNode> child = new LinkedList<>();

        List<Integer> values = new LinkedList<>();
        for (int i = 0; i < father.size(); i++) {
            TreeNode f_node = father.get(i);
            values.add(f_node.val);
            if (f_node.left != null) child.add(f_node.left);
            if (f_node.right != null) child.add(f_node.right);
            if (i == father.size() -1){
                father = child;
                i = -1;
                lists.add(values);
                values = new LinkedList<>();
                child = new LinkedList<>();
            }
        }

        return lists;
    }

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (null == root) return lists;

        List<TreeNode> father = new LinkedList<>();
        father.add(root);
        List<TreeNode> child = new LinkedList<>();

        List<Integer> values = new LinkedList<>();
        for (int i = 0; i < father.size(); i++) {
            TreeNode f_node = father.get(i);
            values.add(f_node.val);

            if (f_node.right != null) {
                if ((i & 1) == 0){
                    child.add(f_node.right);
                }else child.add(f_node.left);
            }
            if (f_node.left != null){
                if ((i & 1) == 0){
                    child.add(f_node.left);
                }else child.add(f_node.right);
            }
            if (i == father.size() -1){
                father = child;
                i = -1;
                lists.add(values);
                values = new LinkedList<>();
                child = new LinkedList<>();
            }
        }

        return lists;
    }

    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     * 例如:
     * 给定二叉树:[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回：
     *
     * [3,9,20,15,7]
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        int[] orders = new int[0];
        if (null == root) return orders;

        List<TreeNode> father = new LinkedList<>();
        father.add(root);
        List<TreeNode> child = new LinkedList<>();
        List<Integer> values = new LinkedList<>();
        for (int i = 0; i < father.size(); i++) {
            TreeNode f_node = father.get(i);
            values.add(f_node.val);

            if (f_node.left != null) child.add(f_node.left);
            if (f_node.right != null) child.add(f_node.right);

            if (i == father.size() -1){
                father = child;
                i = -1;
                child = new LinkedList<>();
            }
        }
        orders = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            orders[i] = values.get(i);
        }
        return orders;
    }

    /**
     * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
     * 返回一个包含所有深度的链表的数组。
     *
     * 示例：
     *
     * 输入：[1,2,3,4,5,null,7,8]
     *
     *         1
     *        /  \
     *       2    3
     *      / \    \
     *     4   5    7
     *    /
     *   8
     *
     * 输出：[[1],[2,3],[4,5,7],[8]]
     *
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        ListNode[] lists = new ListNode[0];
        int depth = maxDepth(tree);
        if (0 == depth) return lists;
        lists = new ListNode[depth];

        List<TreeNode> father = new LinkedList<>();
        father.add(tree);
        List<TreeNode> child = new LinkedList<>();

        ListNode values = new ListNode(-1);
        ListNode p = values;
        for (int i = 0, j = 0; i < father.size(); i++) {
            TreeNode f_node = father.get(i);
            p.next = new ListNode(f_node.val);
            p = p.next;
            if (f_node.left != null) child.add(f_node.left);
            if (f_node.right != null) child.add(f_node.right);
            if (i == father.size() -1){
                father = child;
                i = -1;
                lists[j] = values.next;
                j++;
                values = new ListNode(-1);
                p = values;
                child = new LinkedList<>();
            }
        }
        return lists;
    }


    /**
     * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
     * 如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new LinkedList<>();
        List<Integer> leafs2 = new LinkedList<>();
        leafOfTree(root1, leafs1);
        leafOfTree(root2, leafs2);
        if (leafs1.size() != leafs2.size()) return false;

        for (int i = 0; i < leafs1.size(); i++) {
            if (leafs1.get(i) != leafs2.get(i)) return false;
        }
        return true;
    }

    public void leafOfTree(TreeNode root, List<Integer> leafs){
        if (null == root) return;
        if (null == root.left && null ==root.right){
            leafs.add(root.val);
            return;
        }
        leafOfTree(root.left, leafs);
        leafOfTree(root.right, leafs);
    }


    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
     * 那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
     *
     * 示例:
     *
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * 注意:合并必须从两个树的根节点开始。
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (null == root1) return root2;
        if (null == root2) return root1;

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    /**
     * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (null == root) return false;



        return false;
    }

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过也可能不穿过根结点。
     *
     * 示例 :
     * 给定二叉树
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
     *
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) return 0;
        int l_h = maxDepth(root.left);
        int r_h = maxDepth(root.right);
        int max = l_h + r_h;
        int max_left = diameterOfBinaryTree(root.left);
        int max_right = diameterOfBinaryTree(root.right);
        if (max_left > max && max_left > max_right) max =  max_left;
        if (max_right > max && max_right > max_left) max =  max_right;
        return max;
    }

    /**
     * 给出一棵二叉树，其上每个结点的值都是0或1。
     * 每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     * 例如，如果路径为0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数01101，也就是13。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     *
     * @param root
     * @return
     */
    private int _sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeaf(root, 0);
        return _sum;
    }
    private void sumRootToLeaf(TreeNode root, int sum) {
        if (root == null) return;
        sum <<= 1;
        sum += root.val;
        sumRootToLeaf(root.left, sum);
        sumRootToLeaf(root.right, sum);
        if (root.left == null && root.right == null){
            _sum += sum;
        }
    }

    /**
     * 给定一个二叉树，计算 整个树 的坡度 。
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
     * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     * 整个树 的坡度就是其所有节点的坡度之和。
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        return Math.abs(sum(root.left) - sum(root.right))
                + findTilt(root.left)
                + findTilt(root.right);
    }

    public int sum(TreeNode root){
        if(root == null) return 0;
        return root.val
                + sum(root.left)
                + sum(root.right);
    }

    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
     * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
     * 若最底层为第 h 层，则该层包含 1~2h个节点。
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int dl = depth(root.left), dr = depth(root.right);
        if (dl == dr){
            return (1 << dl) + countNodes(root.right);
        }else {
            return (1 << dr) + countNodes(root.left);
        }
    }
    private int depth(TreeNode root){
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}