package com.quan.array;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >=0 && carry > 0; i--) {
            int s = digits[i] + 1;
            digits[i] = s > 9 ? 0 : s;
            carry = s > 9 ? 1 : 0;
        }
        if (carry == 0){
            return digits;
        }else {
            int[] sum = new int[digits.length + 1];
            sum[0] = 1;
            return sum;
        }
    }
}
