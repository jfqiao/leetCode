package code;

/**
 * Created by hgf on 2016/12/10.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(binarySearchNonrecursive(nums, 2));

    }

//    public static int searchInsert(int[] nums, int target) {
//        return binarySearch(nums, target, 0, nums.length - 1);
//    }
//
//    public static int binarySearch(int[] nums, int target, int low, int high) {
//        if (low <= high) {
//            int mid = (low + high) / 2;
//            if (nums[mid] > target)
//                return binarySearch(nums, target, low, mid - 1);
//            else if (nums[mid] < target)
//                return binarySearch(nums, target, mid + 1, high);
//            else
//                return mid;
//        }
//        return low;
//    }

    public static int binarySearchNonrecursive(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pos = 0;
        while (low <= high) {
            pos = (low + high) / 2;
            if (nums[pos] > target)
                high = pos - 1;
            else if (nums[pos] < target)
                low = pos + 1;
            else {
                return pos;
            }
        }
        return low;
    }
}
