package com.quan.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Canfinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //构建邻接链表graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] req : prerequisites) {
            graph.get(req[0]).add(req[1]);
        }
        //dfs找环
        int[] finish = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, finish, graph)) return false;
        }
        return true;
    }

    //dfs找环
    private boolean dfs(int node, int[] finish, List<List<Integer>> graph) {
        if (finish[node] == 1) return true;
        if (finish[node] == -1) return false;

        finish[node] = 1;
        for (Integer pre : graph.get(node)) {
            if (dfs(pre, finish, graph)) return true;
        }
        finish[node] = -1;
        return false;
    }
}
