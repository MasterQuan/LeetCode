package com.quan.tow_pointers;

public class ReverseVowels {
    /**
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     *
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
     *
     * 示例 1：
     * 输入：s = "hello"
     * 输出："holle"
     *
     * 示例 2：
     * 输入：s = "leetcode"
     * 输出："leotcede"
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        if (null == s || s.length() < 2) return s;
        char[] ss = s.toCharArray();
        for (int i = 0, j = ss.length - 1; i < j; ) {
            if (isVowels(ss[i])){
                if (isVowels(ss[j])){
                    char c = ss[i];
                    ss[i] = ss[j];
                    ss[j] = c;
                    i++;
                    j--;
                }else {
                    j--;
                }
            }else {
                i++;
            }
            System.out.println("i:" + i + " j:" + j);
        }
        return new String(ss);
    }
    private static boolean isVowels(char c){
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }else return false;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}
