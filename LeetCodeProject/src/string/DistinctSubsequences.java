package string;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * 动态规划问题。分解成子问题解决。
 * 
 * @author jfqiao
 *
 */
public class DistinctSubsequences {
	int[][] nums;
	char[] sc;
	char[] tc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequences ds = new DistinctSubsequences();
		String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		String t = "bcddceeeebecbc";
		System.out.println(ds.numDistinct(s, t));
	}

	public int numDistinct(String s, String t) {
		if (s.length() < t.length())
	        return 0;
	    if (s.equals(t))
	    	return 1;
		nums = new int[s.length()][t.length()];
		sc = s.toCharArray();
		tc = t.toCharArray();
		for (int[] num : nums) {
			for (int i = 0; i < num.length; i++)
				num[i] = -1;
		}
		return numDistinctTopDown(0, 0);
	}
	
	//递归解决，时间过长.
	public int numDistinctRecursive(String s, int n, String t, int m) {
		int result = 0;
		if (m == t.length()) {
			return 1;
		}
		else {
			char c = t.charAt(m);
			for (int i = n; i <= s.length() - (t.length() - m); i++) {
				if (c == s.charAt(i))
					result += numDistinctRecursive(s, i + 1, t, m + 1);
			}
		}
		return result;
	}
	
	//还可以继续优化，不用初始化临时数组为－１．
	//利用返回值为－１，这样可以调整
	public int numDistinctTopDown(int n, int m) {
		int result = 0;
		if (m == tc.length) {
			return 1;
		}
		int row = sc.length -1 - n;
		int col = tc.length - 1 - m;
		if (nums[row][col] >= 0) {
			return nums[row][col];
		}
		else {
			char c = tc[m];
			for (int i = n; i <= sc.length - (tc.length - m); i++) {
				if (c == sc[i]) {
					int tmp = numDistinctTopDown(i + 1, m + 1);
					//这个break是必要的，没有的话会造成很多冗余递归。
					if (tmp == 0)
						break;
					result += tmp;
				}
			}
		}
		nums[row][col] = result;
		return result;
	}
	
}
