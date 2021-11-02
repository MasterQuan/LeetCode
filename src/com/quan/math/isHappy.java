package com.quan.math;

public class isHappy {
    public static void main(String[] args) {
        System.out.println(new isHappy().happy(19));
    }

    public boolean isHappy(int n) {
        int slow = happy(n);
        int fast = happy(happy(n));
        while (slow != fast && fast!= 1 && slow!= 1){
            slow = happy(slow);
            fast = happy(happy(fast));
        }
        if (1 == fast || 1 == slow){
            return true;
        }else return false;
    }
    private int happy(int n){
        int happy = 0;
        while (n!=0){
            int div = n % 10;
            n = n / 10;
            happy += div * div;
        }
        return happy;
    }

}
