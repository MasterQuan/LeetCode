package com.quan.array;

import java.util.HashMap;

public class relativeSortArray {
    /**
     * 给定两个数组，arr1 和 arr2，
     *
     * arr2中的元素各不相同
     * arr2 中的每个元素都出现在arr1中
     * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。
     * 未在arr2中出现过的元素需要按照升序放在arr1的末尾。
     *
     * 示例：
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     *
     * 提示：
     *
     * 1 <= arr1.length, arr2.length <= 1000
     * 0 <= arr1[i], arr2[i] <= 1000
     * arr2中的元素arr2[i]各不相同
     * arr2 中的每个元素arr2[i]都出现在arr1中
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }
        int pos = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 1; j <= count[arr2[i]]; j++) {
                arr1[pos++] = arr2[i];
            }
            count[arr2[i]] = 0;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr1[pos++] = i;
            }
        }
        return arr1;
    }
}
