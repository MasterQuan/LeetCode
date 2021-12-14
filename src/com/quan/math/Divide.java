package com.quan.math;

public class Divide {


    /**
     * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
     *
     * 注意：
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8以及truncate(-2.7335) = -2
     * 假设我们的环境只能存储 32 位有符号整数本题中
     *
     * 示例 1：
     *
     * 输入：a = 15, b = 2
     * 输出：7
     * 解释：15/2 = truncate(7.5) = 7
     *
     * @param a
     * @param b
     * @return
     */
    public static int divide(int a, int b) {
        if(a==Integer.MIN_VALUE && b==-1){
            return Integer.MAX_VALUE;
        }
        if (b == 1) return a;
        if (b == -1) return -a;

        boolean positive = a > 0 && b > 0 || a < 0 && b < 0;
        long absA = a;
        long absB = b;
        absA = Math.abs(absA);
        absB = Math.abs(absB);
        System.out.println("a:" + absA + " b:" + absB);
        int divide = 0;
        if (absA >> 1 > absB){
            while (absA >= absB){
                if (absA >> 1 >= absB){
                    absA -= (absB << 1);
                    divide += 2;
                }else if (absA >= absB){
                    absA -= absB;
                    divide++;
                }
            }
        }else {
            if (absA >> 1 == absB){
                divide = 2;
            }else if (absA >= absB){
                divide = 1;
            }else divide = 0;
        }
        if (divide == 0) return 0;
        return positive ? divide : -divide;
    }

    public int divide2(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(dividend < 0 && divisor < 0)
            return Integer.divideUnsigned(-dividend, -divisor);
        if(dividend<0 && divisor>0)
            return -(Integer.divideUnsigned(-dividend, divisor));
        if(dividend>0 && divisor<0)
            return -(Integer.divideUnsigned(dividend, -divisor));
        return Integer.divideUnsigned(dividend, divisor);
    }

    public static void main(String[] args) {
        System.out.println(divide(231, 3));
    }
}
