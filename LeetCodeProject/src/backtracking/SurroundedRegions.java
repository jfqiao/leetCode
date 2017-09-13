package backtracking;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example, 
 * 	X X X X 
 * 	X O O X 
 * 	X X O X 
 * 	X O X X 
 * After running your function, the board should be:
 * 
 *  X X X X 
 *  X X X X 
 *  X X X X 
 *  X O X X
 * 
 * @author hgf
 *
 */

import java.util.Stack;

public class SurroundedRegions {
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		String[] strs = {"XXXX","XOOX","XXOX","XOXX"};
		char[][] board = new char[strs.length][];
		for (int i = 0; i < strs.length; i++) {
			board[i] = strs[i].toCharArray();
		}
		sr.solve(board);
		output(board);
	}
	
	private Stack<Integer> rowStack;
	private Stack<Integer> colStack;
	public static void output(char[][] board) {
		int rowLen = board.length;
		if (rowLen == 0)
			return;
		int colLen = board[0].length;
		for (int row = 0; row < rowLen; row++) {
			for (int col = 0; col < colLen; col++) {
				System.out.print(board[row][col]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	/*
	 * idea: 在边缘位置找到O， 然后开始利用深度优先（广度优先也可以）寻找上下左右四个位置，
	 * 开始做标记，然后对整个数组未做标记的全部标为X.
	 * 要注意的一个地方就是对上下左右越界控制，细节处理可能需要详细思考。
	 */
	 public void solve(char[][] board) { 
		 if (board == null)
			 return;
		 int rowLen = board.length;
		 if (rowLen == 0)
			 return;
		 rowStack = new Stack<>();
		 colStack = new Stack<>();
		 int colLen = board[0].length;
		 byte[][] marked = new byte[rowLen][colLen];
		 //第一行
		 for (int i = 0; i < colLen; i++) {
			 dfsWithStack(board, marked, 0, i);
//			 DFS(board, marked, 0, i);
		 }
		 //last line 
		 for (int i = 0; i < colLen; i++) {
			 dfsWithStack(board, marked, rowLen - 1, i);
//			 DFS(board, marked, rowLen - 1, i);
		 }
		 
		 //first column except in first line and last line
		 for (int i = 1; i < rowLen - 1; i++) {
			 dfsWithStack(board, marked, i, 0);
//			 DFS(board, marked, i, 0);
		 }
		 //last column except in first line and last line
		 for (int i = 1; i < rowLen - 1; i++) {
			 if (board[i][colLen - 1] == 'O')
			 dfsWithStack(board, marked, i, colLen - 1);
//			 DFS(board, marked, i, colLen - 1);
		 }
		 
		 //set the board with marked, 1->X   0->O
		 for (int i = 0; i < rowLen; i++) {
			 for (int j = 0; j < colLen; j++) {
				 if (marked[i][j] == 0)
					 board[i][j] = 'X';
			 }
		 }
	 }
	 	
	 //深度优先算法递归深度太大，造成stack over flow, 利用栈模拟即可。
	 public void DFS(char[][] board, byte[][] marked, int row, int col) {
		 
		 if (row < 0 || row >= board.length 
				 || col >= board[0].length || col < 0  
				 || marked[row][col] == 1 || board[row][col] == 'X')
			 return;
		 marked[row][col] = 1;
		 DFS(board, marked, row - 1, col);
		 DFS(board, marked, row + 1, col);
		 DFS(board, marked, row, col - 1);
		 DFS(board, marked, row, col + 1);
	 }
	 
	 public void dfsWithStack(char[][] board, byte[][] marked, int row, int col) {
		 rowStack.push(row);
		 colStack.push(col);
		 while (!rowStack.empty()) {
			 row = rowStack.pop();
			 col = colStack.pop();
			 if (row < 0 || row >= board.length 
					 || col >= board[0].length || col < 0  
					 || marked[row][col] == 1 || board[row][col] == 'X')
				 continue;
			 marked[row][col] = 1;
			 colStack.push(col + 1);
			 colStack.push(col - 1);
			 colStack.push(col);
			 colStack.push(col);
			 rowStack.push(row);
			 rowStack.push(row);
			 rowStack.push(row + 1);
			 rowStack.push(row - 1);
		 }
	 }
	 
}
