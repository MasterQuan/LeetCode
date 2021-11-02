package com.quan.array;

import java.util.*;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        Set s = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }
        Object[] o=s.toArray();
        if (s.size()<3){
            return (Integer)o[o.length-1];
        }
        return (Integer)o[o.length-3];
    }
    public int thirdMax2(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            insert(list, num);
        }
        return list.size() < 3 ? list.getFirst() : list.getLast();
    }

    private void insert(LinkedList<Integer> list, int num){
        boolean add = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num) return;

            if (list.get(i) < num){
                add = true;
                list.add(i, num);break;
            }
        }
        if (list.size() < 3 && !add){
            list.add(num);
        }
        if (list.size() > 3){
            list.removeLast();
        }
    }

}
