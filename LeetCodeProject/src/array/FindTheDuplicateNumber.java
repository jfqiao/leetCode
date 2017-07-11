package array;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note: You must not modify the array (assume the array is read only). You must
 * use only constant, O(1) extra space. Your runtime complexity should be less
 * than O(n2). There is only one duplicate number in the array, but it could be
 * 
 * @author fangqiao.jfq
 *
 */
public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		FindTheDuplicateNumber fd = new FindTheDuplicateNumber();
		int[] nums = {1, 3, 4, 2, 1, 5, 6};
		System.out.println(fd.findDuplicate(nums));
	}
	
	public int findDuplicate(int[] nums) {
		int count = 0;
		int fast = nums[0];
		int slow = nums[0];
		while (true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			count++;
			if (fast == slow)
				break;
		}
		fast = nums[0];
		slow = fast;
		for (int i = 0; i < count; i++) {
			fast = nums[fast];
		}
		while (true) {
			if (slow == fast)
				break;
			else {
				fast = nums[fast];
				slow = nums[slow];
			}
		}
		return slow;
	}
}
