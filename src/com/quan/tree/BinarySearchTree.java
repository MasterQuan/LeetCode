package com.quan.tree;

import com.quan.list.ListNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

    /**
     * 给定一个有序整数数组，元素各不相同且按升序排列，
     * 编写一个算法，创建一棵高度最小的二叉搜索树。
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (end < start) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }


    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
     * <p>
     * 示例:
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (null == head) return null;
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (null == head) return null;
        if (head == tail) return null;
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head, slow);
        root.right = sortedListToBST(slow.next, tail);
        return root;
    }

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;
        if (null == root.left && null == root.right) return true;
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((null != min && root.val <= min) || (null != max && root.val >= max)) return false;
        if (!isValidBST(root.left, min, root.val) || !isValidBST(root.right, root.val, max)) {
            return false;
        }
        return true;
    }


    /**
     * 给定一棵二叉搜索树，请找出其中第k小的节点。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (null == root) return -1;
        List<Integer> nums = new LinkedList<>();
        inorderKthTraversal(root, nums, k);
        return nums.get(k - 1);
    }

    private void inorderKthTraversal(TreeNode root, List elements, int k) {
        if (null != root) {
            inorderKthTraversal(root.left, elements, k);
            elements.add(root.val);
            if (elements.size() == k) return;
            inorderKthTraversal(root.right, elements, k);
        }
    }

    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        if (null == root) return -1;
        List<Integer> nums = new LinkedList<>();
        invertedInorderKthTraversal(root, nums, k);
        return nums.get(k - 1);
    }

    private void invertedInorderKthTraversal(TreeNode root, List elements, int k) {
        if (null != root) {
            invertedInorderKthTraversal(root.right, elements, k);
            if (elements.size() >= k) return;
            elements.add(root.val);
            if (elements.size() >= k) return;
            invertedInorderKthTraversal(root.left, elements, k);
            if (elements.size() >= k) return;
        }
    }

    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * 返回满足题意的二叉搜索树的种数。
     * <p>
     * 示例 1：
     * 输入：n = 3
     * 输出：5
     * <p>
     * 示例 2：
     * 输入：n = 1
     * 输出：1
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 0) return 0;

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i - j - 1];
            }
        }
        return nums[n];
    }


    /**
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
     * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     * <p>
     * 例如，
     * 给定二叉搜索树:
     * <p>
     * 4
     * / \
     * 2   7
     * / \
     * 1   3
     * <p>
     * 和值: 2
     * 你应该返回如下子树:
     * <p>
     * 2
     * / \
     * 1   3
     * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) return null;
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    /**
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        List<Integer> elements = new ArrayList<>();
        inorderTraversal(root, elements);
        int minDiff = 0;
        for (int i = 1; i < elements.size(); i++) {
            int abs = Math.abs(elements.get(i) - elements.get(i-1));
            minDiff = (minDiff == 0 || minDiff > abs) ? abs : minDiff;
        }
        return minDiff;
    }

    private void inorderTraversal(TreeNode root, List elements) {
        if (null != root) {
            inorderTraversal(root.left, elements);
            elements.add(root.val);
            inorderTraversal(root.right, elements);
        }
    }

    /**
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = searchBST(root, key);

        if (null == node) {
            return root;
        }else {
            if (null == node.right){
                node = node.left;
            }else {
                TreeNode min_left = getMinNumInBST(root.left);

                node.val = node.right.val;
                node.right = node.right.left;
            }
            return root;
        }
    }

    private TreeNode getMinNumInBST(TreeNode root){
        if (null == root || null == root.left) return root;
        return getMinNumInBST(root.left);
    }

    /**
     *给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     *
     * 假定 BST 有如下定义：
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 例如：
     * 给定 BST [1,null,2,2],
     *    1
     *     \
     *      2
     *     /
     *    2
     * 返回[2].
     *
     * 提示：如果众数超过1个，不需考虑输出顺序
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        return  null;
    }

    /**
     * 给定一个二叉搜索树 root 和一个目标结果 k，
     * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     *
     * 示例 1：
     * 输入: root = [5,3,6,2,4,null,7], k = 9
     * 输出: true

     * 示例 2：
     * 输入: root = [5,3,6,2,4,null,7], k = 28
     * 输出: false
     *
     * 示例 3：
     * 输入: root = [2,1,3], k = 4
     * 输出: true

     * 示例 4：
     * 输入: root = [2,1,3], k = 1
     * 输出: false

     * 示例 5：
     * 输入: root = [2,1,3], k = 3
     * 输出: true
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (null == root) return false;
        return true;
    }

    /**
     *设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
     * 如果指定节点没有对应的“下一个”节点，则返回null。
     *
     * 示例 1:
     * 输入: root = [2,1,3], p = 1
     *   2
     *  / \
     * 1   3
     * 输出: 2
     *
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], p = 6
     *       5
     *      / \
     *     3   6
     *    / \
     *   2   4
     *  /
     * 1
     * 输出: null
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        // 当前节点值小于等于目标值，那么当前目标值的后继者必然在右子树
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        // 否则结果有可能是当前节点，或者在当前节点的左子树中
        // 那么先去左子树找一下试试，找不到的话返回当前节点即是结果
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }


}
