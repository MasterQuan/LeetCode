package com.quan.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个有n个节点的有向无环图，用二维数组graph表示，请找到所有从0到n-1的路径并输出（不要求按顺序）。
 * graph的第 i 个数组中的单元都表示有向图中 i号节点所能到达的下一些结点
 * （译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若为空，就是没有下一个节点了。
 *
 */
public class AllPath {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList();
        backtracking(ans, path, graph, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, LinkedList<Integer> path, int[][] graph, int index){
        //将当前顶点加入到path中
        path.add(index);
        //如果找到最后的顶点，返回
        if (index == graph.length - 1){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int v : graph[index]) {
            backtracking(ans, path, graph, v);
            //回溯
            path.removeLast();
        }
    }
}
