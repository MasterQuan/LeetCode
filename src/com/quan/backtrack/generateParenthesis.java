package com.quan.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 正整数n代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 */
public class generateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n,0,0, res, sb);
        return res;
    }

    public void dfs(int n, int left, int right, List<String> res, StringBuilder sb){
        if(left == n && right == n){
            res.add(sb.toString());
            return;
        }
        if(left > n || right > left || right > n)return;
        sb.append("(");
        dfs(n,left + 1, right, res, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        dfs(n, left, right + 1, res, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
