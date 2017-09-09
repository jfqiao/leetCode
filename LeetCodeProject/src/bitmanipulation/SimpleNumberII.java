package bitmanipulation;

/**
 * Given an array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * 
 * @author fangqiao.jfq
 *
 */

public class SimpleNumberII {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 2, 1, 2, 1, 3, 4};
		System.out.println(new SimpleNumberII().singleNumber(nums));
	}
	
	public int singleNumber(int[] nums) {
		// #curent income ouput
		// # ab c/c ab/ab
		// # 00 1/0 01/00
		// # 01 1/0 10/01
		// # 10 1/0 00/10
		// a=~abc+a~b~c;
		// b=~a~bc+~ab~c;
		int a = 0;
		int b = 0;
		for (int c : nums) {
			int ta = (~a & b & c) | (a & ~b & ~c);
			b = (~a & ~b & c) | (~a & b & ~c);
			a = ta;
		}
		// we need find the number that is 01,10 => 1, 00 => 0.
		return a | b;
	}
}
