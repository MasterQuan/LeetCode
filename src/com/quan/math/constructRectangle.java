package com.quan.math;

public class constructRectangle {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        int w = (int)Math.sqrt(area);
        for (int i = w; i > 0; i--) {
            if (area % i == 0){
                ans[1] = i;
                ans[0] = area / i;
                return ans;
            }
        }
        return ans;
    }
}
