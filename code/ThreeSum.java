package code;
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?  
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class ThreeSum {
   // 先排序对问题有好处�??
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int start = 0;
		// from start to end
		while (start < nums.length) {
			int target = -nums[start];
			int i = start + 1;
			int j = nums.length - 1;
			List<Integer> tmp;
			// if a + b == c
			// we need to search the whole array.
			while (i < j) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					tmp = new ArrayList<>();
					tmp.add(nums[i]);
					tmp.add(nums[j]);
					tmp.add(-target);
					result.add(tmp);
					while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
						i++;
					}
					while (j - 1 > 0 && nums[j] == nums[j - 1]) {
						j--;
					}
					i++;
					j--;
				}
				// if a + b < c
				else if (sum < target) {
					i++;
				}
				// if a + b > c
				else {
					j--;
				}
			}
			// if the next number is equal to the current number.
			//注意用到了start + 1应该是判�? start + 1小于数组长度
			//否则会�?�成访问越界�?
			while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
				start++;
			}
			start++;
		}
		return result;
	}
}
