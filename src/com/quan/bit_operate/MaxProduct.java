package com.quan.bit_operate;

public class MaxProduct {
    public int maxProduct(String[] words) {
        int[] value = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                value[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max_product = 0;
        for (int i = 0, product = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0){
                    product = words[i].length() * words[j].length();
                    max_product = product > max_product ? product : max_product;
                }
            }
        }
        return  max_product;
    }
}
