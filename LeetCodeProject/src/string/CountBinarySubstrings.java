package string;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 * 
 * Substrings that occur multiple times are counted the number of times they occur.
 * 
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * 
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * 
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * Note:
 * 
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 * @author jfqiao
 *
 */
public class CountBinarySubstrings {
	
	public static void main(String[] args) {
		CountBinarySubstrings cbw = new CountBinarySubstrings();
		System.out.println(cbw.countBinarySubstrings("1110"));
	}
	
	// idea: count 1 or 0, then to calculate the number. 
	// for example: n 1 and m 0, then the combination can be min(m, n);
	
	public int countBinarySubstrings(String s) {
		if (s.length() == 0)
			return 0;
		char[] sc = s.toCharArray();
		int onesNum = 0;
		int zerosNum = 0;
		int result = 0;
		
		if (sc[0] == '0')
			zerosNum++;
		else
			onesNum++;
		for (int i = 1; i < sc.length; i++) {
			if (sc[i - 1] == sc[i]) {
				if (sc[i] == '1') {
					onesNum++;
				} else {
					zerosNum++;
				}
			}
			else {
				result += Math.min(zerosNum, onesNum);
				if (sc[i] == '1') {
					onesNum = 1;
				} else {
					zerosNum = 1;
				}
			}
		}
		
		return result + Math.min(zerosNum, onesNum);
    }
}
