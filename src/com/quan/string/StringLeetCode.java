package com.quan.string;

import com.sun.xml.internal.ws.util.StringUtils;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class StringLeetCode {


    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * <p>
     * 示例1:
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     * <p>
     * 示例2:
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        if (lenthOfString(first) == lenthOfString(second)) {
            return oneReplace(first, second);
        } else if (lenthOfString(first) - lenthOfString(second) == 1) {
            return oneInsert(first, second);
        } else if (lenthOfString(second) - lenthOfString(first) == 1) {
            return oneInsert(second, first);
        }
        return false;
    }

    private int lenthOfString(String str) {
        if (null == str) {
            return 0;
        } else return str.length();
    }

    private boolean oneReplace(String str1, String str2) {
        if (lenthOfString(str1) == 0) return true;

        int edit = 0;
        for (int i = 0; i < str1.length() && edit < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                edit++;
            }
        }
        if (edit > 1) {
            return false;
        } else return true;
    }

    private boolean oneInsert(String long_str, String short_str) {
        if (lenthOfString(short_str) == 0) return true;

        int edit = 0, i = 0, j = 0;
        for (; i < long_str.length() && j < short_str.length() && edit < 2; i++, j++) {
            if (long_str.charAt(i) != short_str.charAt(j)) {
                edit++;
                j--;
            }
        }
        if (edit > 1 || i < long_str.length() - 1) {
            return false;
        } else return true;
    }


}
