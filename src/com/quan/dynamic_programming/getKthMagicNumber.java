package com.quan.dynamic_programming;

public class getKthMagicNumber {
    public int getKthMagicNumber(int k) {
        if (k < 1) return 0;
        int[] dp = new int[k];
        dp[0] = 1;
        int idx3 = 0, idx5 = 0, idx7 = 0;
        int pro3, pro5, pro7;
        for (int i = 1; i < k; i++) {
            pro3 = dp[idx3] * 3;
            pro5 = dp[idx5] * 5;
            pro7 = dp[idx7] * 7;

            dp[i] = Math.min(pro3, Math.min(pro5, pro7));
            idx3 = dp[i] == pro3 ? idx3 + 1 : idx3;
            idx5 = dp[i] == pro5 ? idx5 + 1 : idx5;
            idx7 = dp[i] == pro7 ? idx7 + 1 : idx7;
        }
        return dp[k-1];
    }
}
