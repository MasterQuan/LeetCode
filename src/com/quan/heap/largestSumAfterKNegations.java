package com.quan.heap;

import java.util.Arrays;

public class largestSumAfterKNegations {
    int[] data;
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++, k--) {
            if (nums[i] >= 0) break;
            nums[i] = -nums[i];
        }
        int sum = 0;
        Arrays.sort(nums);
        for (int n : nums)
            sum += n;
        if (k != 0 && k % 2 != 0) sum -= 2 * nums[0];
        return sum;
    }

    private void init(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            data[i + 1] = nums[i];
        }

        //从第一个不是叶子节点的元素开始
        for( int i = nums.length >> 1 ; i >= 1 ; i -- )
            shiftDown(i);
    }

    //最小堆核心辅助函数
    private void shiftUp(int k){
        while( k > 1 && data[k >> 1] > data[k]){
            swap(k, k >> 1);
            k >>= 1;
        }
    }

    //最小堆核心辅助函数
    private void shiftDown(int k){
        while( (k << 1) < data.length ){
            // 在此轮循环中,data[k]和data[j]交换位置
            int j = k << 1;
            if( j+1 < data.length && data[j+1] < data[j])
                j ++;
            // data[j] 是 data[2*k]和data[2*k+1]中的最小值
            if( data[k] <= data[j]) break;
            swap(k, j);
            k = j;
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
