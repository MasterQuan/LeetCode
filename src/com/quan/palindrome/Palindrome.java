package com.quan.palindrome;

public class Palindrome {

    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 示例 1:
     * 输入:
     * "abccccdd"
     * 输出:
     * 7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (null == s || s.length() < 1) return 0;
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        boolean hasOdd =false;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] & 1) == 1){
                hasOdd = true;
                chars[i]--;
            }
            len += chars[i];
        }
        return hasOdd ? len+1 : len;
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
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


    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     * 示例 3：
     * 输入：s = "a"
     * 输出："a"
     *
     * 示例 4：
     * 输入：s = "ac"
     * 输出："a"
     *
     * 提示：
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     *
     * @param s
     * @return
     */
    public String longestSubPalindrome(String s) {
        if (s == null || s.length() < 1) return s;


        return null;
    }

}
