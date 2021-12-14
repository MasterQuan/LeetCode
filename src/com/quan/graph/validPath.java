package com.quan.graph;

/**
 *There is a bi-directional graph with n vertices, where each vertex is labeled
 * from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges,
 * where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
 * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * You want to determine if there is a valid path that exists from vertex start to vertex end.
 * Given edges and the integers n, start, and end, return true if there is
 * a valid path from start to end, or false otherwise.
 *
 */
public class validPath {
    int[][] parent;
    public int maxAreaOfIsland(int[][] grid) {
        int h = grid.length, w = grid[0].length, s = 0;
        parent = new int[h * w][2];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++,s++) {
                parent[s][0] = s;

                //是否第一行
                if (i==0){
                    //是否第一列
                    if(j==0){
                    }else {
                        if (grid[i][j] == 1 && grid[i][j-1] == 1){
                            union(s, s - 1);
                        }
                    }
                }else {
                    //是否第一列
                    if(j==0){
                        if (grid[i][j] == 1 && grid[i-1][j] == 1){
                            union(s, s - w);
                        }
                    }else {
                        if (grid[i][j] == 1){
                            if (grid[i][j-1] == 1){
                                union(s, s - 1);
                            }
                            if (grid[i-1][j] == 1){
                                union(s, s - w);
                            }
                        }
                    }
                }

            }
        }

        int max = 0;
        s=0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++,s++) {
                if (grid[i][j] == 1){
                    int A  = find(s);
                    parent[A][1] = parent[A][1] + 1;
                    max = Math.max(max, parent[A][1]);
                }
            }
        }
        return max;
    }

    private void union(int a, int b) {
        parent[find(a)][0] = find(b);
    }

    private int find(int x) {
        if (x != parent[x][0]) {
            parent[x][0] = find(parent[x][0]);
        }
        return parent[x][0];
    }
}
