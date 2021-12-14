package com.quan.dynamic_programming;

import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class dicesProbability {
    public double[] dicesProbability(int n) {
        double[] dices = new double[6 * n + 1];
        double[] ans = new double[5*n + 1];
        for (int i = 1; i <= 6; i++) {
            dices[i] = 1 / 6;
        }
        double sum = 0.0;
        for (int i = 2; i <= n; i++) {
            for (int j = 6 * n; j >= i; j--) {
                sum = 0.0;
                for (int k = 1; k <= 6; k++) {
                    sum += (j - k) >= (i - 1) ? dices[j - k] : 0;
                }
                dices[j] = sum / 6;
            }
        }
        ans = Arrays.copyOfRange(dices,n, 6 * n + 1);
        return ans;
    }
}
