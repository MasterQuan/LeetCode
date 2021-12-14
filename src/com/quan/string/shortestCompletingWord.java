package com.quan.string;

import java.util.Arrays;

/**
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 * 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。
 * 在匹配 licensePlate 中的字母时：
 * 忽略licensePlate 中的 数字和空格 。不区分大小写。
 * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。
 * 可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。
 * 当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个。
 */
public class shortestCompletingWord {
    public static void main(String[] args) {
        shortestCompletingWord s = new shortestCompletingWord();
        String word = "1s3 PSt";
        String[] words = new String[]{"step", "steps", "stripe", "stepple"};

        s.shortestCompletingWord(word, words);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] arr=new int[26];
        for(char c:licensePlate.toCharArray()){
            if(c>='a'&&c<='z'){
                arr[c-'a']++;
            }
            if(c>='A'&&c<='Z'){
                arr[c-'A']++;
            }
        }
        int minIndex=-1;
        int[] temp=new int[26];
        for(int j=0;j<words.length;j++){
            Arrays.fill(temp,0);
            for(char c:words[j].toCharArray()){
                temp[c-'a']++;
            }
            boolean flag=true;
            int i;
            for(i=0;i<26;i++){
                if(arr[i]!=0){
                    if(temp[i]<arr[i]) {
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                minIndex=minIndex==-1?j:minIndex;
                minIndex=words[minIndex].length()>words[j].length()?j:minIndex;
            }
        }
        return words[minIndex];
    }
}
