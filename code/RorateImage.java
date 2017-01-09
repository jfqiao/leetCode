package algorithm.leetcode;

/**
 * Created by hgf on 2016/12/27.
 */
public class RorateImage {

    public static void main(String[] args)  {
        int[][] matrix = {{1,2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateInPlace(matrix);
        output(matrix);
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] newMatrix = new int[len][len];
        for (int row = 0; row < len; row++ ) {
            int newRow = len - 1 - row;
            for (int column = 0; column < len ; column++) {
                newMatrix[column][newRow] = matrix[row][column];
            }
        }
        for (int row = 0; row < len; row++ ) {
            for (int column = 0; column < len ; column++) {
                matrix[row][column] = newMatrix[row][column];
            }
        }
    }

    public static void output(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                System.out.print(matrix[row][column] + "\t");
            }
            System.out.println();
        }
    }

    public static void rotateInPlace(int[][] matrix) {
        //从外圈正方形向内旋转，
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            int curLen = len - 2 * i;
            int last = i + curLen - 1;
            for (int k = 0; k < curLen - 1; k++) {
                int j = k + i;
                int pos = len - 1 - j;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[pos][i];
                matrix[pos][i] = matrix[last][pos];
                matrix[last][pos] = matrix[j][last];
                matrix[j][last] = tmp;
            }
        }
    }
}
