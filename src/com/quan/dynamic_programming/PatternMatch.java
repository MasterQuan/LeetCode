package com.quan.dynamic_programming;

public class PatternMatch {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    //i,j的数值范围从1到s.length和p.length。
    boolean match(String s, String p, int i, int j) {
        //表示没有任何字符需要比较。
        if (i == 0) return false;

        //'.'可以匹配s中的任意字符，所以一直为true;
        if (p.charAt(j - 1) == '.') return true;

        //判断i和j位置的字符是否相等。
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
