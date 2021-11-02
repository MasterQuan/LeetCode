package com.quan.dynamic_programming;

import java.util.List;
import java.util.Stack;

public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }

    void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
        } else {
            B.add(A.remove(A.size() - 1));
            move(n - 1, A, B, C); // 一处递归即可
            C.add(B.remove(B.size() - 1));
        }
    }

    private void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        hanota(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        hanota(n - 1, B, A, C);
    }
}
