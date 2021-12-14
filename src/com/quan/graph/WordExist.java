package com.quan.graph;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。
 * 如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */
public class WordExist {
    private boolean flag = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, visited, i, j, 0, word);
            }
        }
        return flag;
    }

    private void backtrack(char[][] board, boolean[][] visited, int row, int col, int pos, String word){
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || visited[row][col] || board[row][col] != word.charAt(pos) || flag){
            return;
        }
        if (pos == word.length() - 1){
            flag = true;
            return;
        }else {
            visited[row][col] = true;
            backtrack(board, visited, row - 1, col, pos + 1, word);
            backtrack(board, visited, row + 1, col, pos + 1, word);
            backtrack(board, visited, row, col - 1, pos + 1, word);
            backtrack(board, visited, row, col + 1, pos + 1, word);
            visited[row][col] = false;
        }
    }
}
