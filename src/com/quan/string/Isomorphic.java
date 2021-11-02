package com.quan.string;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    /**
     * 给定两个字符串s和t，判断它们是否是同构的。
     * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
     *
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
     * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) return false;
        Map<Object,Integer> map= new HashMap();
        Integer i = 0;
        for (; i < s.length(); i++) {
            if(map.put(s.charAt(i),i) != map.put(t.charAt(i)+"",i)) return false;
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        if(strs.length != pattern.length()) return false;
        for(int i=0; i<strs.length; i++){
            char c = pattern.charAt(i);
            if(!map.containsKey(c)){
                if(map.containsValue(strs[i])) return false;
                map.put(c, strs[i]);
            }else if(!map.get(c).equals(strs[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Isomorphic().isIsomorphic("a", "a"));
    }
}
