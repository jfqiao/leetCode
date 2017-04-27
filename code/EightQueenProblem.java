package code;

import java.util.List;

/**
 * Created by hgf on 2016/12/23
 * 八皇后问题：在一�?8*8的棋盘上，放置八个皇后，使得
 * 任意两个皇后都不在同�?行，同一列，或�?�同�?条斜线上
 * 问：�?共有多少种放法？
 */
public class EightQueenProblem {

    public static void main(String[] args) {

    }

    public <T extends String> void f(T t1, List<? super EightQueenProblem> list) {

    }

    public static int solve(int[][] board) {

        return -1;
    }

    public static boolean isValid(int[][] board) {
        int count_row, count_col;
        for (int row = 0; row < 8; row++) {
            count_row = 0;
            count_col = 0;
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == 1)
                    count_row++;
                if (count_row >= 2)
                    return false;
                if (board[col][row] == 1)
                    count_col++;
                if (count_col >= 2)
                    return false;
            }
        }
        int count_diagonal, y, x;
        for (int k = 6; k >= -6; k--) {
            count_diagonal = 0;
            if (k >= 0) {
                y = k;
                x = 0;
            }
            else {
                y = 0;
                x = -k;
            }
            while (y < 8 && x < 8) {
                if (board[x][y] == 1)
                    count_diagonal++;
                if (count_diagonal >= 2)
                    return false;
                y++;
                x++;
            }
        }
        for (int k = 13; k > 0; k++) {
            if (k >= 7) {
                x = 7;
                y = k - x;
            }
            else {
                x = k;
                y = 0;
            }
            count_diagonal = 0;
            while (y < 8 && x < 8) {
                if (board[x][y] == 1)
                    count_diagonal++;
                if (count_diagonal >= 2)
                    return false;
                y++;
                x--;
            }
        }
    return true;
    }

    public enum Season {
        Spring, Summer, Autumn, Winter;
        void f() {
            System.out.println("this is a method in enum.");
        }
        static void g() {
            System.out.println("static method");
        }
    }
}