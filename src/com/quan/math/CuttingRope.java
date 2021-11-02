package com.quan.math;

public class CuttingRope {
    public int cuttingRope(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int d = n;
        int s = 1;
        while (d != 0){
            if (d == 4){
                s <<= 2; break;
            }else if (d == 2){
                d -= 2;
                s <<= 1;
            }else {
                d -= 3;
                s *= 3;
            }
        }
        return s;
    }
}
