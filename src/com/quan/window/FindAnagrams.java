package com.quan.window;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if (s == null || p ==null || s.length() < p.length() || p.length() < 1) return list;

        int len_p = p.length(), len_s = s.length();
        int[] p_chars = new int[26];
        int[] s_chars = new int[26];
        for (int i = 0; i < len_p; i++) {
            p_chars[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len_p - 1; i++) {
            s_chars[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        while (pos <= len_s - len_p){
            s_chars[s.charAt(pos + len_p - 1) - 'a']++;
            if (Arrays.equals(p_chars, s_chars)){
                list.add(pos);
            }
            s_chars[s.charAt(pos) - 'a']--;
            pos++;
        }

        return list;
    }
}
