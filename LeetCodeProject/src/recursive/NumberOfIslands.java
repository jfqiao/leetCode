package recursive;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * Add by jfqiao:
 * Note: even in the edge, also count as 1. 
 * @author jfqiao
 *
 */

public class NumberOfIslands {
	
	public static void main(String[] args) {
		char[][] grid = {{'1', '1', '1'}, {'0', '0', '0'}, {'1', '1', '1'}};
		NumberOfIslands noi = new NumberOfIslands();
		System.out.println(noi.numIslands(grid));
	}
	
	// depth first or breadth first. 从左上角开始，对遇到的1进行标记
	// 然后记录遇到的没有标记1的个数。
	public int numIslands(char[][] grid) {
		int islandCount = 0;
		int rowLen = grid.length;
		if (rowLen == 0) 
			return 0;
		int colLen = grid[0].length;
		boolean[][] tags = new boolean[rowLen][colLen];
		for (int row = 0; row < rowLen; row++) {
			for (int col = 0; col < colLen; col++) {
				if(tagGrid(grid, tags, row, col))
					islandCount++;
			}
		}
		return islandCount;
	}
	
	// 先标记自己，再标记邻居，防止邻居反过来访问自己造成互相调用。（如果要先标记邻居，再标记自己，算法该怎样写呢？？？）
	public boolean tagGrid(char[][] grid, boolean[][] tags, int row, int col) {
		if (grid[row][col] == '0' || tags[row][col])
			return false;
		
		tags[row][col] = true;
		
		//up
		if (row > 0) {
			tagGrid(grid, tags, row - 1, col);
		}
		
		// down
		if (row < tags.length - 1) {
			tagGrid(grid, tags, row + 1, col);
		}
		
		// left
		if (col > 0) {
			tagGrid(grid, tags, row, col - 1);
		}
		
		// right
		if (col < tags[0].length - 1) {
			tagGrid(grid, tags, row, col + 1);
		}
		
		return true;
	}
}
