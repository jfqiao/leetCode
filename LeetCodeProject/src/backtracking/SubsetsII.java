package backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
 * @author fangqiao.jfq
 * @since 2017/04/27
 * 
 * Problem description:
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If <code>nums = [1,2,2]</code>, a solution is:
 * <code>
   [
    [2],
    [1],
    [1,2,2],
    [2,2],
    [1,2],
    []
   ]
 * </code>
 */
public class SubsetsII {
	private List<List<Integer>> result;
	public static void main(String [] args) {
		int[] nums = {4, 4, 4, 1, 4};
		
		SubsetsII sii = new SubsetsII();
		sii.subsetWithDup(nums);
		System.out.println(sii.result);
	}
	
	public List<List<Integer>> subsetWithDup(int[] nums) {
		Arrays.sort(nums);
		result  = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		subsetWithDupRecursive(nums, 0, list);
		return result;
	}
	
	public void subsetWithDupRecursive(int[] nums, int pos, List<Integer> list) {
		if (pos == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		// the element is in;
		list.add(nums[pos]);
		subsetWithDupRecursive(nums, pos + 1, list);
		
		//skip duplicate elements;
		while (pos < nums.length - 1 && nums[pos] == nums[pos + 1])
			pos++;
		
		// the element is off;
		list.remove(new Integer(nums[pos]));
		subsetWithDupRecursive(nums, pos + 1, list);
	}
}
