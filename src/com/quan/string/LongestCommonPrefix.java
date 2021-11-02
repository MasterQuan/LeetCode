package com.quan.string;

import com.sun.deploy.util.StringUtils;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (null == strs || strs.length < 1) return "";
        if (strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();
        int min_length = Integer.MAX_VALUE;
        for (String str : strs) {
            min_length = null == str ? 0 : Math.min(min_length, str.length());
        }
        for (int i = 0; i < min_length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
