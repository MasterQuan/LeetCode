package com.quan.graph;

public class TestUF {
    private static int[] parent;
    public static void main(String[] args) {
        parent = new int[10];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        union(1,2);
        union(0,1);
        union(0,3);
        union(2,5);
        union(5,7);
        union(7,4);
        union(6,8);
        union(9,8);
        for (int i = 0; i < parent.length; i++) {
            find(i);
            System.out.println("i:" + i + " p:" + parent[i]);
        }
    }


    private static void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    private static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
