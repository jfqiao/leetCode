package backtracking;

import java.util.List;
import java.util.ArrayList;

/**
 * Problem description: Given a string containing only digits, restore it by
 * returning all possible valid IP address combinations. For example: Given
 * "25525511135", return ["255.255.11.135", "255.255.111.35"]. (Order does not
 * matter)
 * "1.1.1.111","1.1.11.11","1.1.111.1","1.11.1.11","1.11.11.1","1.111.1.1","11.1.1.11","11.1.11.1","11.11.1.1","111.1.1.1"
 * @author jfq
 *
 */
public class ResoreIPAddress {
	private List<String> resultList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "111111";
		ResoreIPAddress ra = new ResoreIPAddress();
		System.out.println(ra.restoreIpAddresses(s));
	}

	public List<String> restoreIpAddresses(String s) {
		resultList = new ArrayList<String>();
		if (s.length() > 12 || s.length() < 4)
			return resultList;
		restoreRecursive(s.toCharArray(), 0, new String[4], 0);
		return resultList;
	}

	private void restoreRecursive(char[] chs, int pos, String[] strs, int sPos) {
		// the condition should be modified later. This condition is not
		// correct.
		if (pos < chs.length && sPos > 3 || pos >= chs.length && sPos <= 3)
			return;
		if (pos == chs.length && sPos == 4) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 4; i++) {
				if (i < 3) {
					sb.append(strs[i]);
					sb.append(".");
				} else
					sb.append(strs[i]);
			}
			if (!resultList.contains(sb.toString()))
				resultList.add(sb.toString());
			return;
		}

		if (pos < chs.length) {
			// current position contains only one digit
			strs[sPos] = new String(chs, pos, 1);
			restoreRecursive(chs, pos + 1, strs, sPos + 1);

			// current position contains two digits  (Zero can not be the first digit if there are more than one digit.)
			if (pos < chs.length - 1 && chs[pos] != '0') {
				strs[sPos] = new String(chs, pos, 2);
				restoreRecursive(chs, pos + 2, strs, sPos + 1);

				if (pos < chs.length - 2) {
					// current position contains three digits
					strs[sPos] = new String(chs, pos, 3);
					if (Integer.parseInt(strs[sPos]) > 255)
						return;
					restoreRecursive(chs, pos + 3, strs, sPos + 1);
				}
			}
		}
	}
}
