package com.quan.backtrack;

import java.util.Arrays;

public class NQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        //构建N*N的矩阵
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b,'.');
        }
        backtracking(n, 0, board);
        return count;
    }

    private void backtracking(int n, int row, char[][] board){
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, board)){
                board[row][col] = 'Q';
                backtracking(n, row + 1, board);
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
}
