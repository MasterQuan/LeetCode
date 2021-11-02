package com.quan.string;

import java.util.ArrayList;
import java.util.List;

public class ZConvert {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int index = 0;
        boolean inCrease = false;
        for (int i = 0; i < s.length(); i++) {
            sbs[index].append(s.charAt(i));
            if (index == 0 || index == numRows - 1){
                inCrease = !inCrease;
            }
            if (inCrease){
                index++;
            }else {
                index--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) {
            res.append(sb);
        }
        return res.toString();
    }
}
