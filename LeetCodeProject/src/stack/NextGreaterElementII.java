package stack;

import java.util.Stack;

/**
 * Problem description: Given a circular array (the next element of the last
 * element is the first element of the array), print the Next Greater Number for
 * every element. The Next Greater Number of a number x is the first greater
 * number to its traversing-order next in the array, which means you could
 * search circularly to find its next greater number. If it doesn't exist,
 * output -1 for this number.
 * 
 * Example 1: Input: [1,2,1] Output: [2,-1,2] Explanation: The first 1's next
 * greater number is 2; The number 2 can't find next greater number; The second
 * 1's next greater number needs to search circularly, which is also 2.
 * 
 * @author hgf
 *
 */
public class NextGreaterElementII {
	public static void main(String[] args) {
		int[] nums = {};
		NextGreaterElementII nge = new NextGreaterElementII();
		int[] result = nge.nextGreaterElements(nums);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
	}

	public int[] nextGreaterElements(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i]  = -1;
		}
		Stack<Integer> stack = new Stack<Integer>();
		
		int i = 0;
		while (i < nums.length) {
			while (!stack.empty() && nums[stack.peek()] < nums[i]) {
				result[stack.pop()] = nums[i];
			}
			stack.push(i);
			i++;
		}
		i = 0;
		while (stack.size() > 1 && i < nums.length) {
			while (!stack.empty() && nums[stack.peek()] < nums[i])
				result[stack.pop()] = nums[i];
			i++;
		}
		return result;
	}
}
