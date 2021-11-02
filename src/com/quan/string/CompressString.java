package com.quan.string;

public class CompressString {

    /**
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
     * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
     * 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     *
     * 示例1:
     *  输入："aabcccccaaa"
     *  输出："a2b1c5a3"
     *
     * 示例2:
     *  输入："abbccd"
     *  输出："abbccd"
     *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     *
     * @param S
     * @return
     */
    public String compressString(String S) {
        if (null == S || S.length() <= 2) return S;

        StringBuilder sb = new StringBuilder();
        final int len = S.length();
        char c = S.charAt(0);
        int ct = 1;

        for (int i = 1; i < len; i++) {
            if (S.charAt(i) != c){
                sb.append(c).append(ct);
                if (sb.length() > len) return S;
                ct = 1;
                c = S.charAt(i);
            }else{
                ct++;
            }
        }
        sb.append(c).append(ct);
        if (sb.length() > len) return S;
        return sb.toString();
    }

    /**
     *给你一个字符数组 chars ，请使用下述算法压缩：
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     * 如果这一组长度为 1 ，则将字符追加到 s 中。
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。
     * 需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
     *
     * 请在 修改完输入数组后 ，返回该数组的新长度。
     * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
     *
     * @param chars
     * @return
     */
//    public int compress(char[] chars) {
//    }
}
