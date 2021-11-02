package com.quan.array;

import java.util.HashMap;
import java.util.Stack;

public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> bigger = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()){
                stack.push(nums2[i]);
            }else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()){
                    bigger.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        while (!stack.isEmpty()){
            bigger.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = bigger.get(nums1[i]);
        }
        return res;
    }
}

