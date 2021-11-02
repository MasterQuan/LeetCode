package com.quan.bit_operate;

public class ConverNumber {
    public int convertInteger(int A, int B) {
//        int count = 0;
//        if (A == B) return count;
//
//
//        for (int i = A ^ B; i !=0 ; i = i >> 1) {
//            count += (i & 1);
//        }
        return Integer.bitCount(A ^ B);
    }
}
