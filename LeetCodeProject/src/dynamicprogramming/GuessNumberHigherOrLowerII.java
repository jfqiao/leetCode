package dynamicprogramming;

/**
 * 
 * @author jfqiao
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * 
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 * 
 * Example:
 * 
 * n = 10, I pick 8.
 * 
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * 
 * Game over. 8 is the number I picked.
 * 
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */

public class GuessNumberHigherOrLowerII {
	public static void main(String[] args) {
		GuessNumberHigherOrLowerII ghl = new GuessNumberHigherOrLowerII();
		System.out.println(ghl.getMoneyCount(2));
	}
	
	public int getMoneyCount(int n) {
		int[][] mem = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mem[i][j] = -1;
			}
		}
		return getMoneyCountRecursive(1, n, mem);
	}
	
	public int getMoneyCountRecursive(int start, int end, int[][]mem) {
		if (start >= end) 
			return 0;
		if (mem[start - 1][end - 1] > -1) {
			return mem[start - 1][end - 1];
		}
		int result;
	    if (end - 1 == start) {
			result =  start;
		}
		else if (end - 2 == start) {
			result = (start + end) / 2;
		}
		else {
			int min = Integer.MAX_VALUE;
			for (int i = start; i <= end; i++) {
				int pre = getMoneyCountRecursive(start, i - 1, mem);
				int next = getMoneyCountRecursive(i + 1, end, mem);
				int tmp = pre > next ? pre : next;
				tmp += i;
				if (min > tmp)
					min = tmp;
			}
			result = min;
		}
		mem[start - 1][end - 1] = result;
		return result;
	}

}
