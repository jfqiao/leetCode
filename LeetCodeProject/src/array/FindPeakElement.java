package array;

/**
 * problem description:
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and
 * return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
 * function should return the index number 2. Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4] Output: 1 or 5 Explanation: Your function can
 * return either index number 1 where the peak element is 2, or index number 5
 * where the peak element is 6. Note:
 * 
 * Your solution should be in logarithmic complexity.
 */

public class FindPeakElement {
	
	public int findPeakElement2(int[] nums) {
		if(nums.length == 1)
            return 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
	}

	public int findPeakElement(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high - 1) {
			int middle = (low + high) / 2;
			if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1])
				return middle;
			else {
				if (nums[middle] > nums[middle + 1]) {
					high = middle - 1;
				} else {
					low = middle + 1;
				}
			}
		}
		if (low == high)
			return low;
		else
			return nums[low] > nums[high] ? low : high;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 1};
		FindPeakElement fpe = new FindPeakElement();
		int e = fpe.findPeakElement2(nums);
		System.out.println(e);
	}
}
