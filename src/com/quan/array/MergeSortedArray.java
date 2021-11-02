package com.quan.array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums2 || n < 1) return;

        int i = m - 1, j = n -1, pos = m + n -1;
        for (; i >= 0 && j >= 0 && pos >=0 ;) {
            if (nums1[i] <= nums2[j]){
                nums1[pos] = nums2[j];
                j--;
            }else {
                nums1[pos] = nums1[i];
                i--;
            }
            pos--;
        }

        //判断A是否先到头,把B的数据移入A中;
        if (i == -1) {
            for (int k = 0; k <= j ; k++) {
                nums1[k] = nums2[k];
            }
        }
    }
}
