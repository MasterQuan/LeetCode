package com.quan.string;

public class StrToInt {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0)
            return 0;

        int res = 0;//存储结果
        int boundary = Integer.MAX_VALUE / 10;//正整数最大边界
        int start = 1;//起始转换数字位置
        int sign = 1;//正负标识，-1负数，1正数

        if(c[0] == '-') {
            sign = -1;
        }else if(c[0] != '+'){
            start = 0;
        }

        for(int i = start; i < c.length; i++) {
            if(c[i] < '0' || c[i] > '9') break;
            //-2147483648 ~ 2147483647
            if(res > boundary || res == boundary && c[i] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[i] - '0');
        }
        return sign * res;
    }
}
