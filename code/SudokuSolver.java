package algorithm.leetcode;

import java.util.Arrays;

/**
 * Sudoku描述：一个9*9的表格，分为9个小的3*3的小方格
 * 满足：每行、每列、每个小方格都是1-9九个数字。
 * 实例如下：
 * 5	1	9     7   4   8    6	3	2
 * 7	8	3	  6   5   2    4	1	9
 * 4	2	6	  1	  3	  9	   8	7	5
 *
 * 3	5	7     9	  8	  6    2	4	1
 * 2	6	4     3   1   7    5	9	8
 * 1	9	8     5   2   4	   3	6	7
 *
 * 9	7	5     8   6   3	   1	2	4
 * 8	3	2     4   9   1	   7	5	6
 * 6	4	1     2   7   5	   9	8	3
 *
 */
public class SudokuSolver {

    public static void main(String[] args) {
        String[] strs = {"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."};
        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++) {
            board[i] = strs[i].toCharArray();
        }
        long t1 = System.currentTimeMillis();
        solveSudoku(board);
        System.out.println(System.currentTimeMillis() - t1);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }


    //预处理思路：从左往右，从上往下遍历所有的格子，如果该格子已经已经填充，
    //则移动到下一个格子。每次填充一个数字之后重新回到第一个格子再次遍历。
    //一直到遍历到最后一个格子则停止,此时要进行预测方格中应该填充得数字。

    public static void solveSudoku(char[][] board) {
        int count = 0;
        //every time traverse the board, insert number
        //if we do not insert one number, break the loop.
        while (true) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (insert(board, i, j)) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                break;
            }
            count = 0;
        }
        int[] pos = findNextEmpty(board);
        preInsert(board, pos[0], pos[1]);
    }

    /**
     *
     * @param nums 目标放歌
     * @param row 行号
     * @param col 列号
     * @return 该位置是否插入成功。
     * 两种情况：1、该位置不需要插入已经存在数字了
     *          2.该位置不确定插入哪个数字。
     */
    public static boolean insert(char[][] nums, int row, int col) {
        if (nums[row][col] != '.')
            return false;
        else {
            boolean[] valid = new boolean[9];
            setValid(nums, valid, row, col);
//            int row_start = row / 3 * 3;
//            int col_start = col / 3 * 3;
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    char number = nums[i + row_start][j + col_start];
//                    if ( number != '.')
//                        valid[number - 49] = true;
//                }
//            }
//            for (int i = 0; i < 9; i++) {
//                int pos = nums[i][col];
//                if (pos != '.')
//                    valid[pos - 49] = true;
//                pos = nums[row][i];
//                if (pos != '.')
//                    valid[pos - 49] = true;
//            }
            int num = -1;
            int count = 0;
            for (int i = 0; i < 9; i++) {
                if (!valid[i]) {
                    count++;
                    num = i;
                }
                if (count == 2)
                    return false;
            }
            if (count == 0)
                return false;
            nums[row][col] = (char) (num + 49);
            return true;
        }
    }

    // public static boolean insert(int[][] nums, int row, int col) {
//        if (nums[row][col] != 0)
//            return false;
//        else {
//            boolean[] valid = new boolean[9];
//            int row_start = row / 3 * 3;
//            int col_start = col / 3 * 3;
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    int number = nums[i + row_start][j + col_start];
//                    if ( number != 0)
//                        valid[number - 1] = true;
//                }
//            }
//            for (int i = 0; i < 9; i++) {
//                int pos = nums[i][col];
//                if (pos != 0)
//                    valid[pos - 1] = true;
//                pos = nums[row][i];
//                if (pos != 0)
//                    valid[pos - 1] = true;
//            }
//            int num = -1;
//            int count = 0;
//            for (int i = 0; i < 9; i++) {
//                if (!valid[i]) {
//                    count++;
//                    num = i;
//                }
//                if (count == 2)
//                    return false;
//            }
//            if (count == 0)
//                return false;
//            nums[row][col] = num + 1;
//            return true;
//        }
//    }

    /**
     * 检验一个方格是否是有效的，
     * @param board target character array
     * @return whether the board is valid. i.e. this board satisfy sudoku condition.
     */
    public static boolean isValidSudoku(char[][] board) {
        int[] tags = new int[9];

        // 先检测行
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    tags[board[i][j] - 49]++;
                }
            }
            if (!test(tags))
                return false;
        }


        //检测列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[j][i]))
                    tags[board[j][i] - 49]++;
            }
            if (!test(tags))
                return false;
        }


        //检测九宫格, i表示第几个九宫格
        //按从上往下，从左往右的规则，
        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    char value = board[row * 3 + j][col * 3 + k];
                    if (Character.isDigit(value))
                        tags[value - 49]++;
                }
            }
            if (!test(tags))
                return false;
        }
        return true;
    }

    public static boolean test(int[] tags) {
        for (int i = 0; i < 9; i++) {
            if (tags[i] > 1)
                return false;
            else
                tags[i] = 0;
        }
        return true;
    }

    /**
     *
     * @param board target character array
     * @return whether the board does not have '.' character.
     */
    public static boolean isComplete(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    return false;
            }
        }
        return true;
    }

    /**
     * for position (i, j) predict a number and insert into the board.
     * this will be recursive.
     * @param board target array.
     * @param i row
     * @param j column
     */
    public static void preInsert(char[][] board, int i, int j) {

        boolean[] valid = new boolean[9];
        setValid(board, valid, i, j);
        for (int k = 0; k < 9; k++) {
            if (!valid[k]) {
                board[i][j] = (char) (k + 49);
                int[] pos = findNextEmpty(board);
                preInsert(board, pos[0], pos[1]);
                if (isValidSudoku(board) && isComplete(board)) {
                    return;
                } else {
                    board[i][j] = '.';
                }
            }
        }
    }

    public static void setValid(char[][] nums, boolean[] valid, int row, int col) {
        int row_start = row / 3 * 3;
        int col_start = col / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char number = nums[i + row_start][j + col_start];
                if (number != '.')
                    valid[number - 49] = true;
            }
        }
        for (int i = 0; i < 9; i++) {
            int pos = nums[i][col];
            if (pos != '.')
                valid[pos - 49] = true;
            pos = nums[row][i];
            if (pos != '.')
                valid[pos - 49] = true;
        }
    }

    public static int[] findNextEmpty(char[][] board) {
        int[] result = new int[2];
        outter:
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                {
                    result[0] = i;
                    result[1] = j;
                    break outter;
                }
            }
        }
        return result;
    }

}