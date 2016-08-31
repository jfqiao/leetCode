/*
Problem describe:
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

/**
 * 此题还没有理解清楚，
 * 如果只用一个数组保存原数组，该如何复原？
 * shuffle()这个方法采取随机数，任意交换两个位置的值。
 * 此题应该还有解?待思考。
 */

public class Solution {
    private int [] nums;
    private int [] sh;
    public Solution(int[] nums) {
        this.nums=nums;
        this.sh=new int [nums.length];
        for(int i=0;i<sh.length;i++){
            sh[i]=nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random ran=new Random();
        if(sh.length==0)return sh;
        int i=ran.nextInt(sh.length);
        int j=ran.nextInt(sh.length);
        int tmp=sh[i];
        sh[i]=sh[j];
        sh[j]=tmp;
        return sh;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
