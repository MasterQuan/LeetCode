package com.quan.dynamic_programming;

/**
 * 
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 *
 */
public class coinChange {
    //动态规划法
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] change = new int[max];
        change[0] = 0;
        for (int i = 1; i < change.length; i++) {
            change[i] = max;
            for (int j = 0; j < coins.length; j++) {
                int idx = i - coins[j];
                if (idx >= 0 && change[idx] != -1){
                    change[i] = Math.min(change[i], change[idx] + 1);
                }
            }
            if (change[i] == max){
                change[i] = -1;
            }
        }
        return change[amount];
    }
}
