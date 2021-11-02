package com.quan.bit_operate;

public class InsertBits {
    /**
     * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
     * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，
     * 不足之处用 0 补齐。具体插入过程如图所示。
     * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
     *
     * 示例1:
     *  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
     *  输出：N = 1100(10001001100)
     *
     * 示例2:
     *  输入： N = 0, M = 31(11111), i = 0, j = 4
     *  输出：N = 31(11111)
     *
     * @param N
     * @param M
     * @param i
     * @param j
     * @return
     */
    public int insertBits(int N, int M, int i, int j) {

//        int allOnes = ~0;
//        int left = allOnes << (i + 1);
//        int right = (1 << i) - 1;
//        int mask = left | right;
//        //将N的i和j之间的位清零
//        int clear = mask & N;
//
//        //将N移到正确位置
//        int m_shift = M << i;
//        return clear | m_shift;

        for (int k = i; k <= j; k++) {
            if ((N&(1<<k))!=0) N &= ~(1 << k); // 如果第k位为1，则将其置为0
        }
        return N | (M << i); // M左移i位后相加
    }
}
