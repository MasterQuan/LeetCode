package com.quan.string;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class UniqueString {
    public static void main(String[] args) {
        UniqueString us = new UniqueString();
        System.out.println(us.isUnique(null));
        System.out.println(us.isUnique(""));
        System.out.println(us.isUnique("a"));
        System.out.println(us.isUnique("leetcode"));
        System.out.println(us.isUnique("abc"));

    }

    public boolean isUnique(String astr){
        if(null == astr || astr.length() < 2) return true;
        if (astr.length() > 128) return false;

        boolean[] chars = new boolean[128];
        for (int i = 0; i < astr.length(); i++) {
            if (chars[astr.charAt(i)]){
                return false;
            }
            chars[astr.charAt(i)] = true;
        }
        return true;
    }
}
