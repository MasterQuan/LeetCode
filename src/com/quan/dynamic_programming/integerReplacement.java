package com.quan.dynamic_programming;

public class integerReplacement {
    public int integerReplacement(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n;i++) {
            if ((i & 1) == 0){  //偶数，用n/2替换n
                dp[i] = dp[i>>1] + 1;
            }else {             //奇数，用n-1或n+1替换n
                dp[i] = Math.min(dp[(i - 1)] + 1, dp[(i + 1) >> 1] + 2);
            }
        }
        return dp[n];
    }

    public int integerReplacement2(int n) {
        long temp = n;
        int count = 0;
        while(temp != 1){
            if((temp & 3) == 3 && temp != 3){
                temp++;
            } else if((temp & 1) == 1){
                temp--;
            } else{
                temp >>= 1 ;
            }
            count++;
        }
        return count;
    }
}
