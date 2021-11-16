package com.quan.string;

public class repeatedSubstringPattern {
    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
     * 给定的字符串只含有小写英文字母，并且长度不超过10000。
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <=1) return false;
        StringBuilder sb = new StringBuilder(s);
        sb.append(s).deleteCharAt(0).deleteCharAt(sb.length() - 1);
        return sb.indexOf(s)>=0 ? true : false;
    }
}
