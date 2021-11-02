package com.quan.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        int i = 3, j = 5;
        for (int k = 1; k <=n ; k++) {
            if (k == i && k==j){
                list.add("FizzBuzz");
                i += 3;
                j += 5;
            }else if (k == i){
                list.add("Fizz");
                i += 3;
            }else if (k == j){
                list.add("Buzz");
                j += 5;
            }else list.add(String.valueOf(k));
        }
        return list;
    }
}
