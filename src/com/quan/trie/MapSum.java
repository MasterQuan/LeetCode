package com.quan.trie;

/**
 * 实现一个 MapSum 类，支持两个方法，insert和sum：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，
 * 整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 */
public class MapSum {

    TrieNode trie;

    /** Initialize your data structure here. */
    public MapSum() {
        trie = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = trie;
        for (int i = 0, pos = 0; i < key.length(); i++, node = node.child[pos]) {
            pos = key.charAt(i) - 'a';
            if (node.child[pos] == null){
                node.child[pos] = new TrieNode();
            }
        }
        node.val = val;
    }

    public int sum(String prefix) {
        int sum = 0;
        TrieNode node = trie;
        for (int i = 0, pos = 0; i < prefix.length(); i++) {
            pos = prefix.charAt(i) - 'a';
            if (node.child[pos] == null){
                return 0;
            }
            node = node.child[pos];
        }
        return sum(node);
    }

    private int sum(TrieNode node) {
        if (node == null) return 0;

        int sum = node.val;
        for ( TrieNode trie : node.child) {
            sum += sum(trie);
        }
        return sum;
    }

    class TrieNode{
        boolean isEnd;
        int val;
        TrieNode[] child = new TrieNode[26];
    }
}
