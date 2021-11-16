package com.quan.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。
 * 键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 */
public class findWords {
    public static final HashMap<Character, Integer> map = new HashMap<>();
    static{
        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";
        for (int i = 0; i < row1.length(); i++) {
            map.put(row1.charAt(i), 1);
        }
        for (int i = 0; i < row2.length(); i++) {
            map.put(row2.charAt(i), 2);
        }
        for (int i = 0; i < row3.length(); i++) {
            map.put(row3.charAt(i), 3);
        }
    }
    public String[] findWords(String[] words) {
        ArrayList<String> sameRow = new ArrayList<>();
        for (String word : words) {
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                if (map.get(word.charAt(i - 1)) != map.get(word.charAt(i))){
                    flag = false;break;
                }
            }
            if (flag){
                sameRow.add(word);
            }
        }
        String[] ans = new String[sameRow.size()];
        for (int i = 0; i < sameRow.size(); i++) {
            ans[i] = sameRow.get(i);
        }
        return ans;
    }
}
