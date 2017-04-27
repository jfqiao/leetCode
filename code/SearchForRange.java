package code;

import algorithm.Util;
import algorithm.sort.QuickSort;

/**
 * Created by hgf on 2016/12/10.
 */
public class SearchForRange {

    public static void main(String[] args) {
        int[] nums = {1};
        Util.output(searchRange(nums, 0));

    }

    public static int binarySearch(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target)
                return binarySearch(nums, target, low, mid - 1);
            else if (nums[mid] < target)
                return binarySearch(nums, target, mid + 1, high);
            else
                return mid;
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int pos = binarySearch(nums, target, 0, nums.length - 1);
        if (pos == -1) {
            return new int[] {-1, -1};
        }
        else {
            int left = pos, right = pos;
            while (left > 0 && nums[left] == nums[left - 1])
                left--;
            while (right < nums.length - 1 && nums[right] == nums[right + 1])
                right++;
            return new int[] {left, right};
        }
    }
}
