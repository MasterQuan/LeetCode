package com.quan.trie;

/**
 * Trie 树或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，
 * 返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，
 * 返回 true ；否则，返回 false 。
 *
 */
public class Trie {
    // root for current trie
    TreeNode root;
    // define the TreeNode
    class TreeNode{
        // children of current node.
        TreeNode[] children;

        // whether is end of a word.
        boolean isEnd;

        //Assume that there are only lowercase letters in the word
        public TreeNode (){
            children = new TreeNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        // Initialize the root without value.
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() < 1) return;

        TreeNode node = root;
        for (int i = 0, pos = 0; i < word.length(); i++, node = node.children[pos]) {
            pos = word.charAt(i) - 'a';
            if (node.children[pos] == null){
                node.children[pos] = new TreeNode();
            }
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() < 1) return false;

        TreeNode node = root;
        for (int i = 0, pos = 0; i < word.length(); i++, node = node.children[pos]) {
            pos = word.charAt(i) - 'a';
            if (node.children[pos] == null){
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() < 1) return true;

        TreeNode node = root;
        for (int i = 0, pos = 0; i < prefix.length(); i++, node = node.children[pos]) {
            pos = prefix.charAt(i) - 'a';
            if (node.children[pos] == null){
                return false;
            }
        }
        return true;
    }
}