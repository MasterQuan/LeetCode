package com.quan.string;

/**
 *给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class CheckPermutation {
    public static void main(String[] args) {
        CheckPermutation cp = new CheckPermutation();
        System.out.println(cp.checkPermutation("",""));
        System.out.println(cp.checkPermutation(null,""));
        System.out.println(cp.checkPermutation(null,null));
        System.out.println(cp.checkPermutation("abc","cba"));
        System.out.println(cp.checkPermutation("abc ","bad"));
    }

    public boolean checkPermutation(String s1, String s2) {
        if (null == s1){
            if (null == s2) return true;
            return false;
        }
        if (null == s2) return false;
        if (s1.length() != s2.length()) return false;

        int [][] cout = new int[128][2];
        for (int i = 0; i < s1.length(); i++) {
            cout[s1.charAt(i)][0]++;
            cout[s2.charAt(i)][1]++;
        }
        for (int i = 0; i < cout.length; i++) {
            if (cout[i][0] != cout[i][1])
                return false;
        }

        return true;
    }
}
