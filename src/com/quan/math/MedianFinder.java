package com.quan.math;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> big;//大顶
    PriorityQueue<Integer> small;//小顶

    /** initialize your data structure here. */
    public MedianFinder() {
        big = new PriorityQueue<>((n1, n2) -> n2 - n1);
        small = new PriorityQueue<>();
    }

    public void addNum(int num) {
        big.add(num);
        small.add(big.poll());
        if(big.size() + 1 < small.size())
            big.add(small.poll());
    }

    public double findMedian() {
        if(small.size() > big.size())
            return small.peek();
        return (double)(big.peek() + small.peek()) / 2;
    }
}
