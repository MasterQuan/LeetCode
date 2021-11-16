package com.quan.dynamic_programming;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int max_length = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                right++;
            }
            if (s.charAt(i) == ')' && right > 0){
                right--;
                if (i > 0){
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i] > 0){
                        dp[i] += dp[i - dp[i]];
                    }
                    max_length = Math.max(max_length, dp[i]);
                }
            }
        }
        return max_length;
    }
}
