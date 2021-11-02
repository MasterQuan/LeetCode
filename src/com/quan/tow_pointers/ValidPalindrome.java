package com.quan.tow_pointers;

public class ValidPalindrome {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 解释："amanaplanacanalpanama" 是回文串
     *
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     * 解释："raceacar" 不是回文串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (null == s) return false;
        String lowCase = s.toLowerCase();
        for (int i = 0, j = lowCase.length() - 1; i < j; ) {
            if (lowCase.charAt(i) >= '0' && lowCase.charAt(i) <='9'
                    || lowCase.charAt(i) >= 'a' && lowCase.charAt(i) <='z'){
                if (lowCase.charAt(j) >= '0' && lowCase.charAt(j) <='9'
                        || lowCase.charAt(j) >= 'a' && lowCase.charAt(j) <='z'){
                    if (lowCase.charAt(i) != lowCase.charAt(j)){
                        return false;
                    }else {
                        i++;
                        j--;
                    }
                }else {
                    j--;
                }
            }else {
                i++;
            }
        }
        return true;
    }

    /**
     * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if (s == null) return false;
        if (s.length() <= 2) return true;
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                return valid(s, left, right - 1) || valid(s, left + 1, right);
            }
        }
        return true;
    }

    private boolean valid(String s, int l,int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
