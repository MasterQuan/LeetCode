package com.quan.tow_pointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        Set<Character> chars = new HashSet<>();
        chars.add(s.charAt(0));
        int max = 1, left = 0, right = left + 1;
        while (right < s.length()){
            char c = s.charAt(right);
            if (chars.contains(s.charAt(right))){
                max = right - left > max ? right - left : max;
                for (int i = left; i < right; ) {
                    if (s.charAt(i) != c){
                        i++;
                    }else {
                        left = i + 1; break;
                    }
                }

            }else {
                chars.add(s.charAt(right));
            }
            right++;
        }
        max = right - left > max ? right - left : max;
        return max;
    }
}
