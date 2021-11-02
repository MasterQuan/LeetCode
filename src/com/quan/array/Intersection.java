package com.quan.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] nums = new int[0];
        if (null == nums1 || nums1.length < 1
                || null == nums2 || nums2.length < 1){
            return nums;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)){
                set2.add(num);
            }
        }
        nums = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            nums[i] = num;
            i++;
        }

        return nums;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if (null == nums1 || nums1.length < 1
                || null == nums2 || nums2.length < 1)
            return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int size = 0;
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result[size] = nums1[i];
                size += 1;
                i += 1;
                j += 1;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                i += 1;
            } else {
                j += 1;
            }
        }
        return Arrays.copyOfRange(result, 0, size);
    }
}
