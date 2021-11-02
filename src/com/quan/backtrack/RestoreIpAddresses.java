package com.quan.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。
 * 你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> ans = new LinkedList<>();
        StringBuilder ip = new StringBuilder(s);
        int dotNum = 0;
        backtrack(ans, ip, 0, 0);
        return ans;
    }
    public void backtrack(LinkedList ans, StringBuilder ip, int startIndex, int dotNum){
        if (dotNum == 3){
            if (isValid(ip,startIndex,ip.length() - 1)){
                ans.add(ip.toString());
            }
            return;
        }
        for (int i = startIndex; i < ip.length(); i++) {
            if (isValid(ip, startIndex, i)){
                ip.insert(i + 1, '.');
                dotNum++;
                backtrack(ans, ip, i+2, dotNum);
                dotNum--;
                ip.deleteCharAt(i + 1);
            }else break;
        }
    }

    // 判断字符串s在左闭右闭区间[start, end]所组成的数字是否合法
    private Boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }

}
