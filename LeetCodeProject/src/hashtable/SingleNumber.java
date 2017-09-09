package hashtable;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * tags: Hash Table, Bit Manipulation
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer tmp = map.get(nums[i]);
			if (tmp == null) {
				map.put(nums[i], 1);
			} else
				map.put(nums[i], 2);
		}
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			Integer value = map.get(key);
			if (value == 1)
				return key;
		}
		return 0;
	}
	
	//使用异或
	public int singleNumber2(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
		}
		return result;
	}
}
