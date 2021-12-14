package com.quan.array;

public class ReversePairs {
    int count = 0;
    public int reversePairs(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return count;
    }

    private void sort(int[] nums, int i, int j) {
        if (i >= j) return;
        int m = i + (j - i) / 2;
        sort(nums,i, m);
        sort(nums,m + 1, j);
        merge(nums, i, j);
    }

    private void merge(int[] nums, int i, int j) {
        int mid = i + (j - i) / 2;
        int p1 = i, p2 = mid + 1;
        int rightCount = 0;
        int idx = 0;

        int[] newNums = new int[j - i + 1];
        while (p1 <= mid || p2 <= j) {
            if (p2 <= j && (p1 > mid || nums[p2] < nums[p1])) {
                rightCount++;
                newNums[idx++] = nums[p2++];
            } else {
                count += rightCount;
                newNums[idx++] = nums[p1++];
            }
        }
        System.arraycopy(newNums, 0, nums, i, j - i + 1);
    }
}
