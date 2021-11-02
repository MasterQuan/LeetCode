package com.quan.stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
//        int[] ans = new int[temperatures.length];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < temperatures.length; i++) {
//            if (stack.isEmpty()){
//                stack.push(i);
//            }else {
//                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
//                    ans[stack.peek()] = i - stack.pop();
//                }
//                stack.push(i);
//            }
//        }
//        return ans;

        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (Integer i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
