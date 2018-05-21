package dynamicprogramming;
/**
 * We are playing the Guess Game. The game is as follows:
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * 
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * 
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example:
 * n = 10, I pick 6.
 * 
 * Return 6.
 * @author jfqiao
 * @category Binary Search
 */
public class GuessNumberHigherOrLower {
	public int myNum;
	
	public int guess(int n) {
		if (myNum > n) 
			return 1;
		else if (myNum < n) 
			return -1;
		else
			return 0;
	}
	
	public int guessNumber(int n) {
		int low = 1;
		int high = n;
		while (low <= high) {
//			int middle = (low + high) / 2;
//			if (middle < low) {
//				middle = low + (high - low) / 2;
//			}
			int middle = low + (high - low) / 2; // careful about overflow. so we need to change code. 
			if (guess(middle) == 1) 
				low = middle + 1;
			else if (guess(middle) == -1)
				high = middle - 1;
			else
				return middle;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		GuessNumberHigherOrLower ghl = new GuessNumberHigherOrLower();
		ghl.myNum = 1702766719;
//		System.out.println(Integer.MAX_VALUE);
		System.out.println(ghl.guessNumber(2126753390));
	}
}
