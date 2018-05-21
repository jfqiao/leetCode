package array;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * @author jfqiao
 *
 */
public class RotateArray {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		RotateArray ra = new RotateArray();
		ra.rotate2(nums, 3);
		for (int i : nums)
			System.out.print(i + "\t");
	}
	
	public void rotate(int[] nums, int k) {
		if (nums.length == 0)
			return;
		k = k % nums.length;
		while (k > 0) {
			int last = nums[nums.length - 1];
			for (int i = nums.length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = last;
			k--;
		}
	}
	
	// 空间换时间，需要申请大小同输入相同的空间。
	public void rotate2(int[] nums, int k) {
		if (nums.length == 0)
			return;
		k = k % nums.length;
		int[] tmp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			tmp[i] = nums[i];
		}
		int start = nums.length - k;
		int index = 0;
		for (int i = start; i < nums.length; i++) {
			nums[index++] = tmp[i];
		}
		for (int i = 0; i < start; i++) {
			nums[index++] = tmp[i];
		}
	}
	
	// 空间换时间，可以只申请k（k < nums.length / 2)个整数，k - nums.length / 2 (k > nums.length)
	public void rotate3(int[] nums, int k) {
		
	}
	
}
