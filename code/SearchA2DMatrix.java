/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Solution {
    // 此题矩阵比杨氏矩阵规则更加严格，可以利用杨氏矩阵查找，也可以利用另一种二分法查找。效率应该是一样的。
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if (rowLen == 0)
            return false;
        int colLen = matrix[0].length;
        int row = rowLen - 1;
        int col = 0;
        while (true) {
            if (row < 0 || col >= colLen)
                return false;
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                col++;
            else 
                row--;
        }
    }
}
