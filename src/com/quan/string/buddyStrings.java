package com.quan.string;

/**
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，
 * 就返回true；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 */
public class buddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length() || s.length() < 2) {
            return false;
        }
        int diff = 0;
        int l = -1, r = -1;
        int[][] chars = new int[2][26];
        for (int i = 0; i < s.length(); i++) {
            chars[0][s.charAt(i) - 'a']++;
            chars[1][goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) {
                diff++;
                if (diff > 2) return false;
                if (diff == 1) {
                    l = i;
                } else {
                    r = i;
                }
            }
        }
        if (diff == 0) {
            for (int c : chars[0]) {
                if (c > 1) return true;
            }
            return false;
        }

        if (diff == 1) {
            return false;
        } else if (s.charAt(r) == goal.charAt(l) && s.charAt(l) == goal.charAt(r)) {
            return true;
        } else return false;

    }
}
