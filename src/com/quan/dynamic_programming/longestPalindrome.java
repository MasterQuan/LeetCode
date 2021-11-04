package com.quan.dynamic_programming;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class longestPalindrome {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max_len = 0, p = 0, q = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                    if (max_len < j - i){
                        p = i;
                        q = j;
                        max_len = j - i;
                    }
                }
            }
        }
        return s.substring(p, q + 1);
    }
}
