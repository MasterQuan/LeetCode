package com.quan.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 树可以看成是一个连通且 无环的无向图。
 * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，
 * 且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组
 * edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。
 * 如果有多个答案，则返回数组edges中最后出现的边。
 */
public class findRedundantConnection {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0] - 1, b = edge[1] - 1;
            if (!union(a, b)) return edge;
        }
        return new int[0];
    }
    private boolean union(int a, int b) {
        int A = find(a), B = find(b);
        if (A == B) return false;
        parent[A] = B;
        return true;
    }
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
