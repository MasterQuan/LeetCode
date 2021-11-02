package com.quan.string;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例 1：
 *
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 *
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 *
 * 提示：
 *
 * 字符串长度在 [0, 500000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        ReplaceBlank rb = new ReplaceBlank();

        System.out.println(rb.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ",27));
    }

    public String replaceSpaces(String s, int length) {
        if (length < 1) return s;

        int ct = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 32) ct++;
        }
        int len = length + ct * 2;
        char[] chars = new char[len];
        for (int i = length - 1, j = len - 1; i >= 0 ; i--) {
            if (s.charAt(i) == 32){
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }else{
                chars[j--] = s.charAt(i);
            }
        }

        return new String(chars);
    }

    public String replaceSpace(String s) {
        if (null == s || s.length() < 1) return s;

        int length = s.length();
        int ct = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 32) ct++;
        }
        int len = length + ct * 2;
        char[] chars = new char[len];
        for (int i = length - 1, j = len - 1; i >= 0 ; i--) {
            if (s.charAt(i) == 32){
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }else{
                chars[j--] = s.charAt(i);
            }
        }
        return new String(chars);
    }
}
