package com.quan.graph;

public class solve {
    public void solve(char[][] board) {
        //从边上开始，dfs将'O'替换成'o'
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[i].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        //将board中所有的'O'替换成'X','o'替换成'O'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == 'o'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int row, int col){
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != 'O')
            return;
        board[row][col] = 'o';

        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);
    }
}
