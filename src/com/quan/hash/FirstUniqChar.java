package com.quan.hash;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (null == s || s.length() < 1) return -1;
        HashMap<Character, Boolean> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hash.put(s.charAt(i), hash.containsKey(s.charAt(i)) ? false : true);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash.get(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        if (null == s || s.length() < 1) return -1;
        int[] flags = new int[26];
        for (int i = 0; i < 26; i++) {
            flags[i] = -2;              //该字符从未出现过
        }

        int pos;
        for (int i = 0; i < s.length(); i++) {
            pos = s.charAt(i) - 'a';
            if (flags[pos] == -2){
                flags[pos] = i;
            }else if (flags[pos] == -1){
                continue;
            }else {
                flags[pos] = -1;           //该字符重复出现过
            }
        }
        int min = s.length();
        for (int i : flags) {
            min = i < min && i != -2 && i != -1 ? i : min;
        }
        return min == s.length() ? -1 : min;
    }
}
