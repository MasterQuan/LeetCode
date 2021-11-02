package com.quan.bit_operate;

public class Bit_Operate {

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
     * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     *
     * 提示：
     * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，
     * 输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
     * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
     * 因此，在上面的示例 3中，输入表示有符号整数 -3。
     *
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。
     *
     * 示例 2：
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。
     *
     * 示例 3：
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *
     * 提示：
     * 输入必须是长度为 32 的 二进制串 。
     * 进阶：
     * 如果多次调用这个函数，你将如何优化你的算法？
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
     *
     * 示例 1：
     * 输入：n = 1
     * 输出：true
     * 解释：20 = 1
     *
     * 示例 2：
     * 输入：n = 16
     * 输出：true
     * 解释：24 = 16
     *
     * 示例 3：
     * 输入：n = 3
     * 输出：false
     *
     * 示例 4：
     * 输入：n = 4
     * 输出：true
     *
     * 示例 5：
     * 输入：n = 5
     * 输出：false
     * 提示：
     * -231 <= n <= 231 - 1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(0 >= n){
            return false;
        }else {
            return (n & (n - 1)) == 0;
        }
    }

    public boolean isPowerOfThree(int n) {
        if(0 >= n){
            return false;
        }else {
            return (n & (n - 1)) == 0;
        }
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0 || (n & (n-1)) != 0){//check(is or not) a power of 2.
            return false;
        }
        if ((n & 0xaaaaaaaa) == 0)
            return true;
        return false;
    }

    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     *
     * 示例 1：
     * 输入：x = 1, y = 4
     * 输出：2
     * 解释：
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * 示例 2：
     * 输入：x = 3, y = 1
     * 输出：1
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
