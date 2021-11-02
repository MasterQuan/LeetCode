package com.quan.array;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

public class AlienSorted {
    /**
     * 某种外星语也使用英文小写字母，但可能顺序 order 不同。
     * 字母表的顺序（order）是一些小写字母的排列。
     * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，
     * 只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1, min = 0, div = 0; i < words.length; i++) {
            min = Math.min(words[i-1].length(), words[i].length());
            for (int j = 0; j < min; j++) {
                div = orders[words[i-1].charAt(j) - 'a'] - orders[words[i].charAt(j) - 'a'];
                if (div > 0){
                    return false;
                }else if (div < 0){
                    break;
                }
            }
            if (div == 0 && words[i].length() < words[i-1].length()) return false;
        }
        return true;
    }

}
