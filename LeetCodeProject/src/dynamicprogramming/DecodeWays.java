package dynamicprogramming;

/**
 * Problem description: A message containing letters from A-Z is being encoded
 * to numbers using the following mapping: <code><br>
 * 'A' -> 1 <br>
 * 'B' -> 2 <br>
 * ... <br>
 * 'Z' -> 26<br>
 * </code> Given an encoded message containing digits, determine the total
 * number of ways to decode it. For example,Given encoded message "12", it could
 * be decoded as "AB" (1 2) or "L" (12). The number of ways decoding "12" is 2.
 * 
 * @author jfq
 *
 */
public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays dw = new DecodeWays();
		String s = "1254125641556611235645123054612303215";
		System.out.println(dw.numDecodesUpToBottom(s));
	}

	public int numDecodings(String s) {
		// return numDecodingsRecursiveBottomToUp(s.toCharArray(), s.length() -
		// 1);
		return numDecodingsRecursiveUpToBottom(s.toCharArray(), 0);
	}

	// 自顶向下递归,非递归方式在下面.
	private int numDecodingsRecursiveUpToBottom(char[] chs, int pos) {
		if (pos == chs.length) {
			return 1;
		}
		if (chs[pos] == '0')
			return 0;
		int result = 0;
		result += numDecodingsRecursiveUpToBottom(chs, pos + 1);
		// 50 -> '2' 54 -> '6'
		if (pos + 1 < chs.length && (chs[pos] == 49 || chs[pos] == 50 && chs[pos + 1] <= 54)) {
			result += numDecodingsRecursiveUpToBottom(chs, pos + 2);
		}
		return result;
	}

	// 自底向上的递归, 非递归方式只需要用数组保存临时数据,避免每次都要计算即可.
	private int numDecodingsRecursiveBottomToUp(char[] chs, int pos) {
		if (pos == -1) {
			return 1;
		}
		if (chs[pos] == '0') {
			if (pos == 0 || pos > 0 && chs[pos - 1] > 50)
				return 0;
			return numDecodingsRecursiveBottomToUp(chs, pos - 2);
		}
		int result = 0;
		result += numDecodingsRecursiveBottomToUp(chs, pos - 1);
		if (pos > 0 && (chs[pos] <= 54 && chs[pos - 1] == 50 || chs[pos - 1] == 49))
			result += numDecodingsRecursiveBottomToUp(chs, pos - 2);
		return result;
	}

	// 非递归的方式,利用空间换时间.
	private int numDecodesUpToBottom(String s) {
		char[] chs = s.toCharArray();
		int[] nums = new int[chs.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = -1;
		}
		return numDecodesUpToBottomWithArray(chs, nums, 0);
	}
   
	// 利用数组保存数据,以后要用直接取出即可.
	private int numDecodesUpToBottomWithArray(char[] chs, int[] nums, int pos) {
		if (pos < nums.length && nums[pos] > -1)
			return nums[pos];
		int result = 0;
		if (pos == chs.length) {
			return 1;
		}
		if (chs[pos] == '0') {
			nums[pos] = 0;
			return 0;
		}
		result += numDecodesUpToBottomWithArray(chs, nums, pos + 1);
		// 50 -> '2' 54 -> '6'
		if (pos + 1 < chs.length && (chs[pos] == 49 || chs[pos] == 50 && chs[pos + 1] <= 54)) {
			result += numDecodesUpToBottomWithArray(chs, nums, pos + 2);
		}
		nums[pos] = result;
		return result;
	}

}
