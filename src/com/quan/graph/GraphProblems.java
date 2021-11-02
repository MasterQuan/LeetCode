package com.quan.graph;

import java.util.*;

public class GraphProblems {

    /**
     * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
     *
     * 示例1:
     * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
     *  输出：true
     *
     * 示例2:
     *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
     *  输出 true
     *
     * 提示：
     * 节点数量n在[0, 1e5]范围内。
     * 节点编号大于等于 0 小于 n。
     * 图中可能存在自环和平行边。
     *
     * @param n
     * @param graph
     * @param start
     * @param target
     * @return
     */
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if ( null == edges.get(graph[i][0])){
                Set<Integer> targets = new HashSet<>();
                targets.add(graph[i][1]);
                edges.put(graph[i][0], targets);
            }else {
                edges.get(graph[i][0]).add(graph[i][1]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            if (target == vertex) return true;

            visited[vertex] = true;
            Set<Integer> targets = edges.get(vertex);
            if (null ==targets || targets.size() == 0) continue;
            for (Integer i : edges.get(vertex)) {
                if (!visited[i]) queue.offer(i);
            }
        }
        return false;
    }

    /**
     * java.lang.NullPointerException
     *   at line 21, Solution.findWhetherExistsPath
     *   at line 57, __DriverSolution__.__helper__
     *   at line 88, __Driver__.main
     */

}
