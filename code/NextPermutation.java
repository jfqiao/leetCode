package algorithm.leetcode;

import algorithm.Util;

/**
 * Created by hgf on 2016/12/9.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 3};
        Util.output(nums);
        nextPermutation(nums);
        Util.output(nums);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1])
                break;
            i--;
        }
        if (i == 0) {
            for (int j = 0; j < nums.length / 2; j++) {
                int end = nums.length - 1 - j;
                int tmp = nums[j];
                nums[j] = nums[end];
                nums[end] = tmp;
            }
        }
        else {
            int bigMin = nums[i];
            // 找到比nums[i - 1]大的最小的数
            int pos = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i - 1]) {
                    if (bigMin >= nums[j]) {
                        bigMin = nums[j];
                        pos = j;
                    }
                }
            }
            //swap nums[i - 1] and nums[j];
            nums[pos] = nums[i - 1];
            nums[i - 1] = bigMin;

            //reverse the array from i;
            for (int j = 0; j < (nums.length - i) / 2; j++) {
                int end = nums.length - 1 - j;
                int tmp = nums[i + j];
                nums[i + j] = nums[end];
                nums[end] = tmp;
            }

        }
    }
}
