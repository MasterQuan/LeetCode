package com.quan.graph;

/**
 * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。
 * 给定一个二维数组 graph，表示图，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。
 * 形式上，对于graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。
 * 该无向图同时具有以下属性：
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的
 * 两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 * 如果图是二分图，返回 true ；否则，返回 false 。
 *
 */
public class isBipartite {
    public boolean isBipartite(int[][] graph) {
        //用两个数组表示每个顶点的归属
        boolean[] groupA = new boolean[graph.length];
        boolean[] groupB = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            //当前顶点不属于任何group
            if(!groupA[i] && !groupB[i]){
                //将当前顶点划归当前group
                if(!group(graph, groupA, groupB, i)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean group(int[][] graph, boolean[] groupA, boolean[] groupB, int v) {
        //当前顶点出现在对方分组b中
        if (groupB[v]) return false;
        //当前顶点出现在己方分组b中
        if (groupA[v]) return true;
        //将当前顶点划给己方分组a中
        groupA[v] = true;
        for (int i : graph[v]) {
            //将当前顶点的邻接顶点全部划归给对方分组b
            if (!group(graph, groupB, groupA, i)){
                return false;
            }
        }
        return true;
    }
}
