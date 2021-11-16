package com.quan.hash;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = new char[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            String s = arrayToString(chars);
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String arrayToString(char[] chars){
       return String.valueOf(chars);
    }
}
