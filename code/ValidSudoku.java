package code;
/*
Problem discripition:
In a 9*9 matrix, for each horizontal line, it contains 1-9,the nine numbers,
and for each vertical line, it also contains 1-9, the nine numbers, 
and for each 3*3 rectangle, (total 9), it also contains nine numbers without repeated.

For a given 9 * 9 matrix, validate if it is a valid sudoku. 
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/
//�?测可行�?�问题比较复杂�?? 可能是NP完全问题�?
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [] tags = new int [9];
        
        // 先检测行
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if(Character.isDigit(board[i][j]))
                {
                    tags[board[i][j] - 49]++;
                }
            }
            if (!test(tags))
                return false;
        }
        
        
        //�?测行    
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if(Character.isDigit(board[j][i]))
                    tags[board[j][i] - 49]++;
            }
            if(!test(tags))
                return false;
        }
        
            
        //�?测九宫格, i表示第几个九宫格
        //按从上往下，从左�?右的规则�?
        for (int i = 0; i < 9; i++)
        {
            int row = i / 3;
            int col = i % 3;
            for (int j = 0; j < 3; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    char value = board[row * 3 + j][col * 3 + k];
                    if (Character.isDigit(value))
                        tags[value - 49]++;
                }
            }
            if(!test(tags))
                return false;
        }
        return true;
    }
    
    public boolean test(int [] tags)
    {
        for (int i = 0; i < 9; i++)
        {
            if (tags[i] > 1)
                return false;
            else
                tags[i] = 0;
        }
        return true;
    }
}
