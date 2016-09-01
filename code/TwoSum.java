/**
problem description:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        int [] result=new int [2];
        outter:
        for(int first=0;first<len;first++){
            for(int second=0;second<len;second++){
                if(nums[first]+nums[second]==target&&first!=second){
                    result[0]=first;
                    result[1]=second;
                    break outter;
                }
            }
        }
        return result;
    }
}
