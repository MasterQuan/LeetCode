package com.quan.window;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。
 * 如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 *
 */
public class MinWindow {
    public static void main(String[] args) {
        minWindow1("ADOBECODEBANC","ABC");
    }
    public static String minWindow1(String s, String t) {
        if (s == null || s.length() < t.length()) return "";

        int[] s_chars = new int[60];
        int[] t_chars = new int[60];
        int lens = s.length(), lent = t.length();

        //统计t中每个字符个数
        for (int i = 0; i < lent; i++) {
            t_chars[t.charAt(i) - 'A']++;
        }
        int min_pos = 0, min = Integer.MAX_VALUE;

        for (int left = 0, right = 0; left <= right && right < lens; right++) {
            s_chars[s.charAt(right) - 'A']++;
            while (isSub(s_chars, t_chars)){
                if (right - left + 1 < min){
                    min = right - left + 1;
                    min_pos = left;
                }
                s_chars[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return min > s.length() ? "":s.substring(min_pos, min_pos + min);
    }

    private static boolean isSub(int[] s_chars, int[] t_chars){
        for (int i = 0; i < s_chars.length; i++) {
            if (s_chars[i] < t_chars[i]) return false;
        }
        return true;
    }
}
