package com.quan.math;

public class MySqrt {
    public int mySqrt(int x) {
        //牛顿迭代法
        long m = x;//防止溢出
        while(m * m > x){
            m = (m + x / m)/2;
        }
        return (int)m;
    }
}
