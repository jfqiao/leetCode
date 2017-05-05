package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Problem description: Given a string S and a string T, find the minimum window
 * in S which will contain all the characters in T in complexity O(n).
 * 
 * For example, <br>
 * <code>
 * S = "ADOBECODEBANC" <br>
 * T = "ABC" </code><br>
 * Minimum window is <code>"BANC"</code>.<br>
 * <strong>Note:</strong> If there is no such window in S that covers all
 * characters in T, return the empty string "". If there are multiple such
 * windows, you are guaranteed that there will always be only one unique minimum
 * window in S.
 * 
 * @author hgf
 * @see SubstringWithConcatenationOfAllWords#findSubstring(String, String[]) 
 * 
 */

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(mws.minWindow(s, t));
	}
	// This question is similar to Substring with concatenation of all words.
	// TLE
	public String minWindow(String s, String t) {
		String result = "";
		Map<Character, SingleChar> map = new HashMap<Character, SingleChar>();
		char[] tchs = t.toCharArray();
		for (char c : tchs) {
			SingleChar sc = map.get(c);
			if (sc == null) {
				map.put(c, new SingleChar(1));
			} else {
				sc.increment();
			}
		}
		char[] schs = s.toCharArray();
		int curPos = 0, visitPos = 0;
		int countChar = 0;
		while (curPos <= schs.length - tchs.length) {
			visitPos = curPos;
			while (visitPos < schs.length) {
				SingleChar sc = map.get(schs[visitPos]);
				if (countChar == t.length() ||
						countChar == 0 && sc == null)
					break;
				if (sc != null && sc.val > 0) {
					sc.decrement();
					countChar++;
				}
				visitPos++;
			}
			if (countChar == t.length()) {
				if (result.length() == 0 ||
						result.length() > visitPos - curPos)
				result = s.substring(curPos, visitPos);
				Set<Character> keys = map.keySet();
				for (Character c : keys) {
					map.get(c).reset();
				}
			}
			curPos++;
			countChar = 0;
		}
		return result;
	}
}

class SingleChar {
	int val;
	int ori;

	public SingleChar(int val) {
		this.val = val;
		this.ori = val;
	}

	public void increment() {
		this.val++;
		this.ori++;
	}

	public void decrement() {
		this.val--;
	}

	public void reset() {
		this.val = this.ori;
	}
}
