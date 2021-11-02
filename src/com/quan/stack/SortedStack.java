package com.quan.stack;

import java.util.Stack;

public class SortedStack {
    private Stack<Integer> stack;
    private Stack<Integer> tmp;

    public SortedStack() {
        stack = new Stack<>();
        tmp = new Stack<>();
    }

    public void push(int val) {
        while (!stack.isEmpty()){
            if (stack.peek() > val) break;
            tmp.push(stack.pop());
        }
        stack.push(val);
        while (!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) stack.pop();
    }

    public int peek() {
        return stack.isEmpty() ? -1: stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
