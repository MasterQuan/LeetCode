package com.quan.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> in;
    Queue<Integer> out;

    public MyStack() {
        this.in = new LinkedList<>();
        this.out = new LinkedList<>();
    }

    public void push(int x) {
        in.offer(x);
        while (!out.isEmpty()){
            in.offer(out.poll());
        }
        Queue<Integer> tmp = in;
        in = out;
        out = tmp;
    }

    public int pop() {
        return out.poll();
    }

    public int top() {
        return out.peek();
    }

    public boolean empty() {
        return out.isEmpty();
    }
}