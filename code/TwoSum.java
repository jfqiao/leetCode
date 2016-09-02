/**
problem description:
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
/**
 *一种加快算法：先排序，最优排序O(nlog2(n))
 * 然后使用有序数组查找相邻元素和大于等于目标，
 * （1,2,3,4，5,6,7）
 * 找到第一个大于或等于，在向前移动即可。
 int [] result=new int [2];
 int i=0;
 for(;i<nums.length-1;i++){
     if(nums[i]+nums[i+1]>=target)break;
 }
 result[1]=i+1;
 for(int j=i;j>0;j--){
     if(nums[j]+nums[i+1]==targer){
         result[0]=j;
         break;
     }
 }
 使用hashtable可以在O(n)解决，但是空间复杂度增加了
 
 public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}

单路：
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
 * 
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
