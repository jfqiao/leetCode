/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.
*/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i, j;
        int current = 0;
        int start, end;
        int closest = Integer.MAX_VALUE;
        while (current < nums.length - 2) {
            i = current + 1;
            j = nums.length - 1;
            while (i < j) {
                start = nums[i];
                end = nums[j];
                int tmp =  start + end + nums[current];
                int dif1 = tmp > target ? tmp - target : target - tmp;
                int dif2 = closest > target ? closest - target : target - closest;
               if (Math.abs(dif1) < Math.abs(dif2) || dif1 >= 0 && dif2 < 0)
                    closest = tmp;

                if (tmp > target)
                    j--;
                else
                    i++;
            }
            current++;
        }
        return closest;
    }
}
