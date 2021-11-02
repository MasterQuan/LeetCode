package com.quan.stack;

import java.util.Stack;

public class ValidBrackets {
    public static void main(String[] args) {
        ValidBrackets vb = new ValidBrackets();
        System.out.println(vb.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (null == s || s.length() < 2) return false;
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));

            }else {
                char c = s.charAt(i);
                switch (c){
                    case ')': {
                        char c0 = (char) stack.peek();
                        if (c0 == '(') stack.pop();
                        else stack.push(c);
                    }break;
                    case ']': {
                        char c0 = (char) stack.peek();
                        if (c0 == '[') stack.pop();
                        else stack.push(c);
                    }break;
                    case '}':{
                        char c0 = (char) stack.peek();
                        if (c0 == '{') stack.pop();
                        else stack.push(c);
                    }break;
                    default: stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
