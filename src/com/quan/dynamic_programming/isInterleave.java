package com.quan.dynamic_programming;

/**
 * 给定三个字符串s1、s2、s3，请判断s3能不能由s1和s2交织（交错）组成。
 * 两个字符串 s 和 t 交织的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 */
public class isInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        //初始化
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i-1][0] && s3.charAt(i-1) == s1.charAt(i-1);
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j-1] && s3.charAt(j-1) == s2.charAt(j-1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i - 1 + j) == s1.charAt(i - 1)) ||
                        (dp[i][j - 1] && s3.charAt(j - 1 + i) == s2.charAt(j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
