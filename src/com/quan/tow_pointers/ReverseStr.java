package com.quan.tow_pointers;

public class ReverseStr {
    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，
     * 就反转这 2k 字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 示例 1：
     * 输入：s = "abcdefg", k = 2
     * 输出："bacdfeg"
     *
     * 示例 2：
     * 输入：s = "abcd", k = 2
     * 输出："bacd"
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 2 || k < 1) return s;
        char[] cs =s.toCharArray();
        int i = 0, j = k -1;
        j = j > cs.length - 1 ? cs.length - 1 : j;
        while (i < cs.length - 1){
            reverseChars(cs, i, j);
            i += (k << 1);
            j += (k << 1);
            j = j > cs.length - 1 ? cs.length - 1 : j;
        }
        return new String(cs);
    }
    private void reverseChars(char[] cs, int i, int j){
        while (i < j){
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
    }
}
