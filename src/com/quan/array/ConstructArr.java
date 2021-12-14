package com.quan.array;

public class ConstructArr {
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        int[][] medium = new int[a.length][2];
        for (int i = 0; i < a.length; i++) {
            if (i == 0){
                medium[i][0] = 1;
            }else {
                medium[i][0] = medium[i-1][0] * a[i - 1];
            }
        }

        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length - 1){
                medium[i][1] = 1;
            }else {
                medium[i][1] = medium[i+1][1] * a[i + 1];
            }
        }
        for (int i = 0; i < a.length; i++) {
            ans[i] = medium[i][0] * medium[i][1];
        }
        return ans;
    }
}
