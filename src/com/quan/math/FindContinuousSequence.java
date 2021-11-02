package com.quan.math;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int pos = target >> 1;
        int max_len = (int) Math.sqrt(target << 1);
        int l = 1, r = l + max_len, s = 0, s0, s1;
        while (l < r){
            s0 = r - l + 1;
            s1 = r + l;
            s = (s0 & 1) == 0 ? (s0 >> 1) * s1 : (s1 >> 1) * s0;
            if (s == target){
                list.add(new int[]{l, r});
                l++;
                r = l + max_len - 1;
            }else if (s > target){
                r--;
            }else {
                l++;
                r = l + max_len - 1;
            }
            if (l > pos) break;
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = generate(list.get(i)[0], list.get(i)[1]);
        }
        return res;
    }

    private int[] generate(int s, int e){
        int[] arr = new int[e - s + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s++;
        }
        return arr;
    }
}
