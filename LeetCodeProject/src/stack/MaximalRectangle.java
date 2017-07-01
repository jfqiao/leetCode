package stack;

import java.util.Stack;

/**
 * problem description: Given a 2D binary matrix filled with 0's and 1's, find
 * the largest rectangle containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
 * 
 * Return 6.
 * 
 * @author jfqiao
 *
 */

public class MaximalRectangle {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		MaximalRectangle mr = new MaximalRectangle();
		System.out.println(mr.maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int result = 0;
		int curArea;
		preprocess(matrix);
		for (int row = 0; row < matrix.length; row++) {
			curArea = largestRectangelAreaWithStack(matrix[row]);
			if (result < curArea)
				result = curArea;
		}
		return result;
	}

	private void preprocess(char[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for (int row = 0; row < rowLen; row++) {
			for (int col = 0; col < colLen; col++) {
				matrix[row][col] -= 48;
				if (row > 0) {
					if (matrix[row][col] == 0 || matrix[row - 1][col] == 0)
						continue;
					matrix[row][col] += matrix[row - 1][col];
				}
			}
		}
	}

	private int largestRectangelAreaWithStack(char[] heights) {
		Stack<Position> stack = new Stack<Position>();
		int area = 0;
		int tmpResult = 0;
		for (int i = 0; i < heights.length; i++) {
			int leftPos = i;
			while (!stack.empty() && heights[stack.peek().pos] > heights[i]) {
				Position left = stack.pop();
				tmpResult = heights[left.pos] * (i - left.leftPos);
				if (area < tmpResult)
					area = tmpResult;
				leftPos = left.leftPos;
			}
			stack.push(new Position(i, leftPos));
		}
		Position margin = null;
		if (!stack.empty()) {
			margin = stack.peek();
		}
		while (stack.size() > 1) {
			Position pos = stack.pop();
			tmpResult = heights[pos.pos] * (margin.pos - pos.leftPos + 1);
			if (tmpResult > area)
				area = tmpResult;
		}
		if (!stack.empty()) {
			tmpResult = heights[stack.peek().pos] * heights.length;
			if (tmpResult > area)
				area = tmpResult;
		}
		return area;
	}

	// 利用动态规划
	public int maximalRectangle2(int[][] matrix) {

		return 0;
	}

}

class Position {
	int leftPos;
	int pos;

	public Position(int pos, int leftPos) {
		this.pos = pos;
		this.leftPos = leftPos;
	}
}
