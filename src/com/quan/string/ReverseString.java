package com.quan.string;

public class ReverseString {

    public void reverseString(char[] s) {
        if (null == s || s.length <=1){
            return ;
        }else {
            int left = 0, right = s.length - 1;
            while (left < right){
                char c = s[left];
                s[left] = s[right];
                s[right] = c;
                left++;
                right--;
            }
        }
    }

    /**
     * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，
     * 反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。
     * 如果 word 中不存在字符 ch ，则无需进行任何操作。
     *
     * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、
     * 直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
     * 返回 结果字符串 。
     *
     * @param word
     * @param ch
     * @return
     */
    public String reversePrefix(String word, char ch) {
        if (null == word || word.length() < 2){
            return word;
        }else {
            StringBuilder sb = new StringBuilder();
            boolean hasCh = false;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                sb.insert(0, c);
                if (c == ch){
                    hasCh = true;
                    sb.append(word.substring(i + 1));
                    break;
                }
            }
            if (hasCh){
                return sb.toString();
            }else {
                return word;
            }
        }
    }

    /**
     * 给定一个字符串S，返回“反转后的”字符串，其中不是字母的字符都保留在原地，
     * 而所有字母的位置发生反转。
     *
     * 示例 1：
     * 输入："ab-cd"
     * 输出："dc-ba"
     *
     * 示例 2：
     * 输入："a-bC-dEf-ghIj"
     * 输出："j-Ih-gfE-dCba"
     *
     * @param s
     * @return
     */
    public String reverseOnlyLetters(String s) {
        if (null == s || s.length() < 2){
            return s;
        }else {
            char[] cs = s.toCharArray();
            int left = 0, right = cs.length - 1;
            while (left < right){
                if (Character.isAlphabetic(cs[left])){
                    if (Character.isAlphabetic(cs[right])){
                        char c = cs[left];
                        cs[left] = cs[right];
                        cs[right] = c;
                        left++;
                        right--;
                    }else {
                        right--;
                    }
                }else {
                    left++;
                }
            }
            return String.valueOf(cs);
        }
    }


    /**
     *
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        if (null == s || s.length() <=1 || n < 1 || n >= s.length()){
            return s;
        }else {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(n)).append(s.substring(0,n));
            return sb.toString();
        }
    }

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     *
     * 示例 1：
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     * 输入: " hello world! "
     * 输出:"world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     * 输入: "a good example"
     * 输出:"example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (null == s || s.length() < 1){
            return s;
        }else {
            String s_trim = s.trim();
            String[] splits = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = splits.length - 1; i >= 0; i--) {
                if (null != splits[i] && splits[i].length() != 0){
                    sb.append(splits[i]).append(" ");
                }
            }
            return sb.toString().trim();
        }
    }
}
