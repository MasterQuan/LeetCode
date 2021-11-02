package com.quan.stack;

public class TripleInOne {
    private int[] stacks;
    private int start_1, start_2, start_3;
    private int pos_1, pos_2, pos_3;

    public TripleInOne(int stackSize) {
        stacks = new int[stackSize * 3];
        start_1 = pos_1 = 0;
        start_2 = pos_2 = stackSize;
        start_3 = pos_3 = stackSize * 2;
    }

    public void push(int stackNum, int value) {

    }

    public int pop(int stackNum) {
        return 0;
    }

    public int peek(int stackNum) {
        return 0;
    }

    public boolean isEmpty(int stackNum) {
        return false;
    }
}