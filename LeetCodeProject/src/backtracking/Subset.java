package backtracking;
import java.util.List;
import java.util.ArrayList;

public class Subset {
	private List<List<Integer>> result;
	public static void main(String[] args) {
		Subset s = new Subset();
		int[] nums = {1, 2, 3, 4};
		s.subset(nums);
		System.out.println(s.result);
	}
	
	public List<List<Integer>> subset(int[] nums) {
		result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		subsetRecursive(nums, 0, list);
		return result;
	}
	
	public void subsetRecursive(int[] nums, int pos, List<Integer> list) {
		if (pos == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		//the element is in.
		list.add(nums[pos]);
		subsetRecursive(nums, pos + 1, list);
		//the element is off.
		list.remove(new Integer(nums[pos]));
		subsetRecursive(nums, pos + 1, list);
	}
}
