package com.quan.string;

/**
 * 大写变小写、小写变大写 : 字符 ^= 32;
 * 大写变小写、小写变小写 : 字符 |= 32;
 * 小写变大写、大写变大写 : 字符 &= -33;
 */
public class UpperLowerCase {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] >= 'A' && chars[i] <= 'Z')
            chars[i] |= 32;
        }
        return new String(chars);
    }

    public String toUpperCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            chars[i] &= -33;
        }
        return new String(chars);
    }

    public String switchCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            chars[i] ^= 32;
        }
        return new String(chars);
    }
}
