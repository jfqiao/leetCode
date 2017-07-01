package array;
import java.util.Random;
/**
 * Problem description:
 * 最大子序列和。
 * 给定一个数组，求数组的子序列中和最大的那个子序列及其值。
 * @author jfqiao
 *
 */

public class MaxSubSum {
	public static void main(String[] args) {
		int[] nums = new int[10];
		Random rand = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = rand.nextInt(20) - 10;
			System.out.print(nums[i] + "\t");
		}
		MaxSubSum mss = new MaxSubSum();
		System.out.println(mss.maxSum(nums));
	}
	
	public int maxSum(int[] nums) {
		int sum = 0;
		int tmpSum = 0;
		for (int i = 0; i < nums.length; i++) {
			tmpSum += nums[i];
			if (tmpSum < 0)
				tmpSum = 0;
			if (sum < tmpSum)
				sum = tmpSum;
		}
		return sum;
	}
}