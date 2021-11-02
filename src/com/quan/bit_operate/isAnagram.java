package com.quan.bit_operate;

public class isAnagram {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     *
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()){
            return false;
        }else {
            int[] s_chars = new int[26];
            int[] t_chars = new int[26];
            for (int i = 0; i < s.length(); i++) {
                s_chars[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < t.length(); i++) {
                t_chars[t.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s_chars.length; i++) {
                if (s_chars[i] != t_chars[i]) return false;
            }
            return true;
        }
    }
}
