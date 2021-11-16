package com.quan.dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典，判定s
     * 是否可以由空格拆分为一个或多个在字典中出现的单词。
     * 说明：拆分时可以重复使用字典中的单词。
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for ( String w:wordDict ) {
            dict.add(w);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
