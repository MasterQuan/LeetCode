package com.quan.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        //回溯
        List<List<Integer>> result = new ArrayList<>();
        backtracking(1,result,new LinkedList<>(),n,k);
        return result;
    }

    private void backtracking(int j, List<List<Integer>> result,
                           LinkedList<Integer> path, int n, int k){
        if(path.size() == k){
            result.add(new ArrayList(path));
        }else{
            for(int i=j; i<=n; i++){
                path.add(i);
                backtracking(i+1,result,path,n,k);
                path.remove(new Integer(i));
            }
        }
    }
}
