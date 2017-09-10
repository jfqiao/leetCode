package dynamicprogramming;
/**
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
Note:
The n will be in the range [1, 1000].
 * @author jfq
 *
 */
public class TwoKeysKeyboard {
	private int count = 0;
	
	public int minSteps(int n) {
		if (n == 1)
			return 0;
		factor(n);
		return count;
	}

	public int a(int a) {
		int i;
		for (i = 2; i <= a - 1; i++)
			if (a % i == 0)
				return 0;// 非素数
		return 1;// 素数
	}

	public void factor(int n) {
		int i;
		if (a(n) == 1)
			count += n;
		else {
			for (i = 2; i <= n / 2; i++) 
				if (n % i == 0) {
					count += i;
					if (a(n / i) == 1)// 素数
					{
						count += n / i;
						break;
					} else// 非素数
						factor(n / i);
					break;
				}
		}
	}
}
