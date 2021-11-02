package com.quan.bit_operate;

public class PrintBinary {
    public String printBin(double num) {
        final String ERROR = "ERROR";
        if (num >=1 || num <=0){
            return ERROR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num > 0){
            //设置32位的长度上限
            if(sb.length() >= 34){
                return ERROR;
            }

            double r = num * 2;
            if(r >= 1){
                sb.append(1);
                num = r - 1;
            }else {
                sb.append(0);
                num = r;
            }
        }
        return sb.toString();
    }
}
