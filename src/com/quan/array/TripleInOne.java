package com.quan.array;

class TripleInOne {
    private static final int numbersOfStack = 3;
    private int[] values;
    private int capacity;
    private int[] sizes;

    public TripleInOne(int stackSize) {
        capacity = stackSize;
        values = new int[capacity * numbersOfStack];
        sizes = new int[numbersOfStack];
    }

    public void push(int stackNum, int value) {
        //判断是否为空
        if (isFull(stackNum)){
            return;
        }else {
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)){
            return -1;
        }
        int top = indexOfTop(stackNum);
        int value = values[top];
        values[top] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)){
            return -1;
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum){
        return sizes[stackNum] == capacity;
    }

    private int indexOfTop(int stackNum){
        return stackNum * capacity + sizes[stackNum] - 1;
    }
}
