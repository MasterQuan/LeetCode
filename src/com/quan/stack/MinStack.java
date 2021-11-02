package com.quan.stack;

import java.util.Stack;

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> valStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() { }

    public void push(int x) {
        if (min > x){
            min = x;
        }
        valStack.push(x);
        minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        valStack.pop();
        if (minStack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = minStack.peek();
        }
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
