package com.quan.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。
 * 每个单词仅由大小写英文字母组成（不含标点符号）。
 * <p>
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s 和一个整数 k ，请你将 s 截断 ，使截断后的句子仅含 前 k 个单词。返回 截断 s后得到的句子。
 */
public class truncateSentence {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder(words[0]);
        int ct = 1;
        for (int i = 1; i < words.length; i++) {
            if (ct == k) break;
            sb.append(" ").append(words[i]);
            ct++;
        }
        return sb.toString();
    }
}
