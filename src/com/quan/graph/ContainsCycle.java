package com.quan.graph;

/**
 * 给你一个二维字符网格数组grid，大小为m x n，你需要检查grid中是否存在 相同值 形成的环。
 * 一个环是一条开始和结束于同一个格子的长度 大于等于 4的路径。对于一个给定的格子，
 * 你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值。
 * 同时，你也不能回到上一次移动时所在的格子。比方说，环(1, 1) -> (1, 2) -> (1, 1)是不合法的，
 * 因为从 (1, 2)移动到 (1, 1) 回到了上一次移动时的格子。
 * 如果 grid中有相同值形成的环，请你返回 true，否则返回 false。
 */
public class ContainsCycle {

    public static void main(String[] args) {
        ContainsCycle contains = new ContainsCycle();
        char[][] grid = new char[3][];
        grid[0] = new char[]{'a', 'b','b'};
        grid[1] = new char[]{'b', 'z','b'};
        grid[2] = new char[]{'b', 'b','a'};

        System.out.println(contains.containsCycle(grid));
    }

    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]){
                    if (dfs(visited, grid, 0, 0, 0, grid[i][j])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(boolean[][] visited, char[][] grid, int i, int j, int direct, char c){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != c){
            return false;
        }
        if (visited[i][j]) return true;
        visited[i][j] = true;
        if (direct == 0){
            return dfs(visited, grid, i - 1, j, 1, c)
                    || dfs(visited, grid, i, j + 1, 2, c)
                    || dfs(visited, grid, i + 1, j, 3, c)
                    || dfs(visited, grid, i, j - 1, 4, c);
        }
        if (direct == 1){
            return dfs(visited, grid, i - 1, j, 1, c)
                    || dfs(visited, grid, i, j + 1, 2, c)
                    || dfs(visited, grid, i, j - 1, 4, c);
        }
        if (direct == 2){
            return dfs(visited, grid, i - 1, j, 1, c)
                    || dfs(visited, grid, i, j + 1, 2, c)
                    || dfs(visited, grid, i + 1, j, 3, c);
        }
        if (direct == 3){
            return dfs(visited, grid, i, j + 1, 2, c)
                    || dfs(visited, grid, i + 1, j, 3, c)
                    || dfs(visited, grid, i, j - 1, 4, c);
        }
        if (direct == 4){
            return dfs(visited, grid, i - 1, j, 1, c)
                    || dfs(visited, grid, i + 1, j, 3, c)
                    || dfs(visited, grid, i, j - 1, 4, c);
        }
        return false;
    }
}