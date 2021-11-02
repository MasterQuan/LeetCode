package com.quan.window;

import java.util.PriorityQueue;

public class KthLargest {
    private int k = 0;
    private PriorityQueue<Integer> queue = null;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue(k + 1);
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

}