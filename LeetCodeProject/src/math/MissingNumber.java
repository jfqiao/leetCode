package math;

/**
 * Problem description: Given an array containing n distinct numbers taken from
 * 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 * 
 * @author jfqiao
 *
 */
public class MissingNumber {
	public static void main(String[] args) {
		MissingNumber mn = new MissingNumber();
		int[] nums = { 0, 1, 2, 3, 4, 9, 8, 7, 5 };
		System.out.println(mn.missingNumber(nums));
	}

	public int missingNumber(int[] nums) {
		int pos = 0;
		int tmp;
		while (pos < nums.length / 2 + 1) {
			tmp = nums[pos];
			if (tmp == pos || tmp == nums.length) {
				pos++;
				continue;
			}
			if (tmp < nums.length) {
				nums[pos] = nums[tmp];
				nums[tmp] = tmp;
			}
			
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i)
				return i;
		}
		return nums.length;
	}
}
