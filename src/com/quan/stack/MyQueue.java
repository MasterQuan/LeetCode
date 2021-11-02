package com.quan.stack;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stackWrite;   // 存数据
    Stack<Integer> stackRead;   // 读数据

    /** Initialize your data structure here. */
    public MyQueue() {
        stackWrite = new Stack<>();
        stackRead = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stackRead.isEmpty()) {
            stackWrite.push(stackRead.pop());
        }
        stackWrite.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stackWrite.isEmpty()) {
            stackRead.push(stackWrite.pop());
        }
        if (!stackRead.isEmpty()) {
            return stackRead.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if (!stackRead.isEmpty()) {
            return stackRead.peek();
        }
        while (!stackWrite.isEmpty()) {
            stackRead.push(stackWrite.pop());
        }
        return stackRead.peek();
    }

    public boolean empty() {
        return stackRead.isEmpty() && stackWrite.isEmpty();
    }
}
