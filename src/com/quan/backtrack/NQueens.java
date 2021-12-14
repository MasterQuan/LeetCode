package com.quan.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<>();

        //构建N*N的矩阵
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b,'.');
        }

        backtracking(ans, n, 0, board);
        return ans;
    }
    private void backtracking(List<List<String>> ans, int n, int row, char[][] board){
        if (row == n) {
            ans.add(array2list(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, board)){
                board[row][col] = 'Q';
                backtracking(ans, n, row + 1, board);
                board[row][col] = '.';
            }
        }

    }
    //校验一个'Q'是否能放置在位置(row, col)上
    private boolean isValid(int row, int col, int n, char[][] board){
        //检查列是否存在'Q';
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        //检查是否在\对角上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //检查是否在/对角上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n ; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    private List<String> array2list(char[][] board){
        List<String> res = new LinkedList<>();
        for (char[] b : board) {
            res.add(new String(b));
        }
        return res;
    }
}
