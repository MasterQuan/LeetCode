package com.quan.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class letterCombinations {
    private static ArrayList<char[]> chars = new ArrayList();
    static {
        chars.add(new char[]{'a', 'b', 'c'});
        chars.add(new char[]{'d', 'e', 'f'});
        chars.add(new char[]{'g', 'h', 'i'});
        chars.add(new char[]{'j', 'k', 'l'});
        chars.add(new char[]{'m', 'n', 'o'});
        chars.add(new char[]{'p', 'q', 'r', 's'});
        chars.add(new char[]{'t', 'u', 'v'});
        chars.add(new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() < 1)
            return result;
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder path, int pos) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        for (int j = 0; j < chars.get(digits.charAt(pos) - '2').length; j++) {
            path.append(chars.get(digits.charAt(pos) - '2')[j]);
            pos++;
            backtrack(result, digits, path, pos);
            path.deleteCharAt(path.length() - 1);
            pos--;
        }
    }
}
