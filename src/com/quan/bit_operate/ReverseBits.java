package com.quan.bit_operate;

public class ReverseBits {
    /**
     * 给定一个32位整数 num，你可以将一个数位从0变为1。
     * 请编写一个程序，找出你能够获得的最长的一串1的长度。
     *
     * 示例 1：
     * 输入: num = 1775(11011101111)
     * 输出: 8
     *
     * 示例 2：
     * 输入: num = 7(0111)
     * 输出: 4
     *
     * @param num
     * @return
     */
    public int reverseBits(int num){
        if (~num == 0) return Integer.bitCount(num);
        int max_len = 1;
        int pre_len = 0;
        int cur_len = 0;

        while (num != 0){
            if ((num & 1) == 1) {
                cur_len++;
            }else if ((num & 1) == 0){
                pre_len = (num & 2) == 0 ? 0 : cur_len;
                cur_len = 0;
            }
            max_len = Math.max(pre_len + cur_len + 1, max_len);
            num >>>= 1;
        }
        return max_len;
    }
}
