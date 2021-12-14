package com.quan.trie;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，
 * 使得所形成的新单词存在于已构建的神奇字典中。
 * 实现 MagicDictionary 类：
 * MagicDictionary() 初始化对象
 * void buildDict(String[]dictionary) 使用字符串数组dictionary设定该数据结构，
 * dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，
 * 判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。
 * 如果可以，返回 true ；否则，返回 false 。
 *
 */
public class MagicDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            TrieNode node = root;
            for (int i = 0, pos = 0; i < s.length(); i++, node = node.child[pos]) {
                pos = s.charAt(i) - 'a';
                if (node.child[pos] == null){
                    node.child[pos] = new TrieNode();
                }
            }
            node.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        if (searchWord == null || searchWord.length() < 1) return false;
        char[] word = searchWord.toCharArray();
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == c) continue;
                word[i] = j;
                if (searchWord(word)) return true;
            }
            word[i] = c;
        }
        return false;
    }

    private boolean searchWord(char[] word){
        if (word == null || word.length < 1) return true;
        TrieNode node = root;
        for (int i = 0, pos = 0; i < word.length; i++, node = node.child[pos]) {
            pos = word[i] - 'a';
            if (node.child[pos] == null) return false;
        }
        return node.isEnd;
    }

    class TrieNode{
        boolean isEnd;
        TrieNode[] child = new TrieNode[26];
    }
}
