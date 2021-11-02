package com.quan.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 */
public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        backTracking(s, 0, ans, path);
        return ans;
    }

    private void backTracking(String s, int startIndex, List<List<String>> ans, LinkedList<String> path) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s, i + 1, ans, path);
            path.removeLast();
        }
    }
    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public  String[][] partition2(String s) {
        List<List<String>> ans = new ArrayList<>();
        LinkedList<String> path = new LinkedList<>();
        backTracking(s, 0, ans, path);
        String[][] result = new String[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = new String[ans.get(i).size()];
            for (int j = 0; j < ans.get(i).size(); j++) {
                result[i][j] = ans.get(i).get(j);
            }
        }
        return result;
    }
}
