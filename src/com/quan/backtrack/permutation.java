package com.quan.backtrack;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class permutation {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        Set<String> result = new HashSet<>();
        LinkedList<Integer> visited = new LinkedList<>();

        backtrack(s, visited, result, new StringBuilder());

        int size = result.size();
        String[] ans = new String[size];
        int i = 0;
        for (String res : result) {
            ans[i] = res;
            i++;
        }
        return ans;
    }

    private void backtrack(String s, LinkedList<Integer> visited, Set<String> result, StringBuilder path){
        if (s.length() == visited.size()){
            result.add(path.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited.contains(i)){
                continue;
            }
            path.append(s.charAt(i));
            visited.add(i);
            backtrack(s, visited,result, path);
            path.deleteCharAt(path.length() - 1);
            visited.removeLast();
        }
    }
}
