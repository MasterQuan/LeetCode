package com.quan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b)->a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right){
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }else {
                right = intervals[i][1] > right ? intervals[i][1] : right;
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}
