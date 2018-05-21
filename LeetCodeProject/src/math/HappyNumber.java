package math;

/**
 * 
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * @author jfqiao
 *
 */

import java.util.Set;
import java.util.HashSet;

public class HappyNumber {
	
	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(0));
	}
	
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int bitSum;
		while (!set.contains(n)) {
			bitSum = bitSqrtSum(n);
			if (bitSum == 1)
				return true;
			else
				set.add(n);
			n = bitSum;
		}
		return false;
    }
	
	public int bitSqrtSum(int n) {
		int sum = 0;
		int bit;
		while (n != 0) {
			bit = n % 10;
			sum += bit * bit;
			n /= 10;
		}
		return sum;
	}
}
