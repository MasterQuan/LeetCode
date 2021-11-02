package com.quan.window;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MovingAverage {
    private int size;
    private int sum = 0;

    private List<Integer> list;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.list = new LinkedList<>();
    }

    public double next(int val) {
        if (list.size() < size){
            list.add(val);
            sum += val;
            return 1.0 * sum / list.size();
        }else {
            list.add(val);
            sum -= list.get(0);
            sum += val;
            list.remove(0);
            return 1.0 * sum / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
