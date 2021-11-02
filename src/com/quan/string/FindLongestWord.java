package com.quan.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FindLongestWord {
    public static void main(String[] args) {
        FindLongestWord flw = new FindLongestWord();
    }

    public String findLongestWord(String s, List<String> dictionary) {
        int max_len = Integer.MIN_VALUE;
        int pos = -1;
        int size = dictionary.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            String ds = dictionary.get(i);
            if (isSubString(s, ds)){
                if (ds.length() > str.length()){
                    str = ds;
                }else if (ds.length() == str.length()){
                    str = str.compareTo(ds) <= 0 ? str : ds;
                }
            }
        }

        return  str;
    }

    //判断s1是否可以通过s2删除字母得到;
    private boolean isSubString(String s1, String s2){
        if (null == s1 || s1.length() < 1 || null ==s2 || s2.length() < 1){
            return false;
        }

        for (int i = 0, j = 0; i < s2.length(); i++) {
            //判断s1是否先于s2到头
            if (j == s1.length())
                return false;

            char c = s2.charAt(i);
            for (; j < s1.length(); j++) {
                if (s1.charAt(j) == c){
                    j++;
                    break;
                }
            }

            if (c != s1.charAt(j - 1)){
                return  false;
            }
        }

        return true;
    }
}

