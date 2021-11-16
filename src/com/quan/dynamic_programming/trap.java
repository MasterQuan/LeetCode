package com.quan.dynamic_programming;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class trap {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min_height = Math.min(leftMax[i], rightMax[i]);
            sum += min_height > height[i] ? min_height - height[i] : 0;
        }
        return sum;
    }
}
