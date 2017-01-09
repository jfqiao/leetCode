package algorithm.leetcode;

/**
 * Created by hgf on 2016/12/18.
 */
public class RotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 1, 2, 3};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        if (nums[0] < nums[len - 1]) {
            return binarySearch(nums, 0, len - 1, target);
        }
        else {
            int low = 0;
            int high = len - 1;
            int mid = 0;
            while (low < high) {
                mid = (low + high) / 2;
                if (nums[mid] > nums[low]) {
                    low = mid;
                }
                else {
                    high = mid;
                }
            }
            int pos = binarySearch(nums, 0, low, target);
            if (pos != -1)
                return pos;
            else
                return binarySearch(nums, low + 1, len - 1, target);
//            if (nums[0] > target)
//                return binarySearch(nums, low + 1, len - 1, target);
//            else
//                return binarySearch(nums, 0, low, target);
        }
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        int mid = 0;
        while (low <= high) {
            mid = (high + low) / 2;
            if (target > nums[mid])
                low = mid + 1;
            else if (target < nums[mid])
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
