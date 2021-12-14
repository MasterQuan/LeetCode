package com.quan.string;

import java.util.Stack;

public class validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < popped.length; i++) {
            while (j < pushed.length &&(stack.isEmpty() || stack.peek() != popped[i])){
                stack.push(pushed[j]);
                j++;
                if (j >= pushed.length) break;
            }

            if (stack.peek() == popped[i]){
                stack.pop();
            }else return false;
        }
        return true;
    }
}
