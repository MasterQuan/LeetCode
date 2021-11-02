package com.quan.string;

import java.util.Arrays;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] chars_a = new int[26];
        for (int i = 0; i < len1; i++) {
            chars_a[s1.charAt(i) - 'a']++;
        }

        int[] chars_b = new int[26];
        int left = 0, right = left + len1 - 1;
        for (int i = 0; i <=right ; i++) {
            chars_b[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(chars_a,chars_b)) return true;
        while (right < len2 - 1){
            right++;
            chars_b[s2.charAt(left++) - 'a']--;
            chars_b[s2.charAt(right) - 'a'] ++;
            if (Arrays.equals(chars_a, chars_b)) return true;
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] chars_a = new int[26];
        for (int i = 0; i < len1; i++) {
            chars_a[s1.charAt(i) - 'a']++;
        }

        int[] chars_b;
        for (int j = 0; j <= len2 - len1; j++) {
            chars_b = new int[26];
            int pos;
            boolean isSame = true;
            for (int i = j; i < j + len1; i++) {
                pos = s2.charAt(i) - 'a';
                chars_b[pos]++;
                if (chars_b[pos] > chars_a[pos]){
                    isSame = false;
                    break;
                }
            }
            if (isSame) return true;
        }
        return false;
    }
}
