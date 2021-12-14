package com.quan.graph;

public class validTicTacToe {
    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0, winX = 0, winO = 0;
        for (String b : board) {
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == 'X') countX++;
                if (b.charAt(i) == 'O') countO++;
            }
            //判断横向赢的数量
            if (b.charAt(0) == b.charAt(1) && b.charAt(1) == b.charAt(2)) {
                if (b.charAt(0) == 'X') winX++;
                if (b.charAt(0) == 'O') winO++;
            }
        }
        //X 数量必须要等于O的数量或者多一个
        if (countX - countO != 1 && countX - countO != 0) return false;

        //判断纵向赢的数量
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == board[1].charAt(i)
                    && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'X') winX++;
                if (board[0].charAt(i) == 'O') winO++;
            }
        }
        //判断对角赢的数量
        if (board[0].charAt(0) == board[1].charAt(1)
                && board[1].charAt(1) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'X') winX++;
            if (board[0].charAt(0) == 'O') winO++;
        }
        if (board[2].charAt(0) == board[1].charAt(1)
                && board[1].charAt(1) == board[0].charAt(2)) {
            if (board[2].charAt(0) == 'X') winX++;
            if (board[2].charAt(0) == 'O') winO++;
        }

        if (winX > 0) {
            //X和O不能同时是赢家
            if (winO > 0) return false;
            //X赢的时候必须比O多个1
            if (countX - countO != 1) return false;
        }
        if (winO > 0 && countO != countX) return false;
        return true;
    }
}
