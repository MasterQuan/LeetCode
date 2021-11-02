package com.quan.array;

import java.util.Arrays;

/**
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 */

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays fma = new FindMedianSortedArrays();
        int[] a = {1,9,13,17, 20};
        int[] b = {3,7,8,10};

//        System.out.println(Arrays.toString(fma.mergeSortedArray(a,b)));
        System.out.println(fma.findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = mergeSortedArray(nums1, nums2);
        int len = merge.length;
        if (len == 0) return 0.0;
        if ((len & 1) == 1){//数组长度为奇数
            return merge[len >> 1];
        }else {             //  数组长度为偶数
            return (merge[ len >> 1] + merge[(len >> 1) - 1]) / 2.0;
        }
    }

    //对有序数据进行合并排序
    private int[] mergeSortedArray(int[] a, int[] b){
        if(null == a || a.length < 1) return b;
        if(null == b || b.length < 1) return a;

        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        //双指针往后检索
        while(i < a.length && j < b.length){
            if (a[i] < b[j]){
                c[k] = a[i];
                i++;
            }else{
                c[k] = b[j];
                j++;
            }

            //结果数组指针后移
            k++;
            //判断是否有短的数组到头；
            if (i == a.length){
                for (; j < b.length; j++) {
                    c[k] = b[j];
                    k++;
                }
            }else if(j == b.length){
                for (; i < a.length; i++) {
                    c[k] = a[i];
                    k++;
                }
            }
        }
        return c;
    }
}
