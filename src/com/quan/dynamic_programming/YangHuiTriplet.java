package com.quan.dynamic_programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class YangHuiTriplet {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triplets = new LinkedList<>();
        for (int i = 1; i <= numRows ; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i){
                    row.add(1);
                }else {
                    row.add(triplets.get(i - 2).get(j - 2) + triplets.get(i - 2).get(j - 1));
                }
            }
            triplets.add(row);
        }
        return triplets;
    }
    public List<Integer> generateRows(int rowIndex) {
        List<List<Integer>> triplets = new LinkedList<>();
        for (int i = 0; i <= rowIndex ; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    row.add(1);
                }else {
                    row.add(triplets.get(i - 1).get(j - 1) + triplets.get(i - 1).get(j));
                }
            }
            triplets.add(row);
        }
        return triplets.get(rowIndex);
    }
}
