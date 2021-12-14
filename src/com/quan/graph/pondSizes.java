package com.quan.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 */
public class pondSizes {
    public int[] pondSizes(int[][] land) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int size = dfs(land, i, j);
                if (size > 0) res.add(size);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }
    private int dfs(int[][] land, int row, int col){
        if (row < 0 || row >= land.length || col < 0 || col >= land[row].length || land[row][col] != 0)
            return 0;
        land[row][col] = -1;
        return dfs(land, row,  col + 1)
                + dfs(land, row, col - 1)
                + dfs(land, row - 1, col - 1)
                + dfs(land, row - 1, col)
                + dfs(land, row - 1, col + 1)
                + dfs(land, row + 1, col - 1)
                + dfs(land, row + 1, col)
                + dfs(land, row + 1, col + 1) + 1;
    }
}
