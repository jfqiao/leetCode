package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem description:
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example: <code><br>
 * S = "ADOBECODEBANC" <br>
 * T = "ABC"           <br></code>
 * Minimum window is <code>"BANC"</code>.
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * @author fangqiao.jfq
 *
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String minWindow(String s, String t) {
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0; i < t.length(); i++) {
    		Integer count = map.get(t.charAt(i));
    		if (count == null) {
    			map.put(t.charAt(i), 1);
    		}
    		else
    			count++;
    	}
    	int start = 0, end = 0, curPos = 0, visitPos = 0;
    	int countChar = 0;
    	char[] schs = s.toCharArray();
    	while (curPos <= schs.length - t.length() ) {
    		visitPos = curPos;
    		
    		while (visitPos < schs.length) {
    			if (countChar == t.length()) {
    				if (end - start == 0 && end - start > visitPos - curPos) {
    					start = curPos;
    					end = visitPos;
    				}
    				break;
    			}
    			Integer count = map.get(schs[visitPos]);
    			if (count != null && count > 0) {
    				countChar++;
    			}
    			visitPos++;
    		}
    		curPos++;
    	}
    	return s.substring(start, end + 1);
    }

}
