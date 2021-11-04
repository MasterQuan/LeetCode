package com.quan.dynamic_programming;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 */
public class nthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] uglies = new int[n];
        uglies[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int ug2, ug3, ug5;
        for (int i = 1; i < uglies.length; i++) {
            ug2 = uglies[idx2] << 1;
            ug3 = uglies[idx3] * 3;
            ug5 = uglies[idx5] * 5;
            uglies[i] = Math.min(Math.min(ug2, ug3), ug5);
            idx2 = ug2 == uglies[i] ? idx2 + 1 : idx2;
            idx3 = ug3 == uglies[i] ? idx3 + 1 : idx3;
            idx5 = ug5 == uglies[i] ? idx5 + 1 : idx5;
        }
        return uglies[n - 1];
    }
}
