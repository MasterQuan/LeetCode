package com.quan.dynamic_programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标
 * 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，
 * 那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 */
public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> up = new ArrayList<>();
        List<Integer> down = up;
        up.add(triangle.get(0).get(0));
        int min, l, r;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> cur = triangle.get(i);
            down = new ArrayList<>();
            for (int j = 0; j < cur.size(); j++) {
                l = j - 1;
                r = j;
                if (l == -1){
                    min = up.get(r);
                }else if (r == up.size()){
                    min = up.get(l);
                }else {
                    min = Math.min(up.get(l), up.get(r));
                }
                down.add(min + cur.get(j));
            }
            up = down;
        }
        min = up.get(0);
        for (int i = 1; i < up.size(); i++) {
            min = Math.min(min, up.get(i));
        }
        return min;
    }
}
