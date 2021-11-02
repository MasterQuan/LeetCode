package com.quan.string;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("abcabcdefg"));
        System.out.println(ls.lengthOfLongestSubstring("bbb"));
        System.out.println(ls.lengthOfLongestSubstring("abcab"));
        System.out.println(ls.lengthOfLongestSubstring(""));
        System.out.println(ls.lengthOfLongestSubstring("dvafabcdefd"));
    }

    public int lengthOfLongestSubstring(String s) {
        //判空
        if (null == s || s.isEmpty()) return 0;

        int length = s.length();
        //定义数组，并初始化
        int[] chars = new int[128];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = -1;
        }

        int len = 0;
        int max_sub_len = 0;
        for (int index = 0; index < length; index++) {
            for (int i = index; i < length; i++) {
                //判断改字符是否出现
                char ch = s.charAt(i);
                if (chars[ch] != -1) {
                    index = chars[ch];
                    max_sub_len  = max_sub_len > len ? max_sub_len : len;

                    //初始化数组
                    for (int c = 0; c < chars.length; c++) {
                        chars[c] = -1;
                    }
                    len = 0;
                    break;
                }else{
                    chars[ch] = i;
                    len++;
                }
            }
        }
        max_sub_len  = max_sub_len > len ? max_sub_len : len;
        return max_sub_len;
    }
}
