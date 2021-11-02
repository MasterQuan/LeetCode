package com.quan.math;

public class CountAndSay {
    /**
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     *
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n < 1) return null;
        if (n == 1) return "1";
        String sb = "1";
        String res = new String();

        for (int i = 2; i <= n; i++) {
            res = countAndSay(sb);
            sb = res;
        }
        return res;
    }
    private static String countAndSay(String s){
        StringBuilder sb = new StringBuilder();
        int ct = 0;
        char pre = '1';
        for (int i = 0; i < s.length(); i++) {

            if (i == 0 || s.charAt(i) == pre){
                ct++;
            }else {
                sb.append(ct).append(pre);
                ct = 1;
            }
            pre = s.charAt(i);
        }
        return sb.append(ct).append(pre).toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay("1"));
        System.out.println(countAndSay("11"));
        System.out.println(countAndSay("21"));
        System.out.println(countAndSay("1211"));
        System.out.println(countAndSay("111221"));
        System.out.println(countAndSay("312211"));
    }
}
