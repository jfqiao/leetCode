package string;

/**
 * Probelm description: Compare two version numbers version1 and version2. If
 * version1 > version2 return 1; if version1 < version2 return -1;otherwise
 * return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not "two and a
 * half" or "half way to version three", it is the fifth second-level revision
 * of the second first-level revision.
 * 
 * Example 1:
 * 
 * Input: version1 = "0.1", version2 = "1.1" 
 * Output: -1 
 * 
 * Example 2:
 * 
 * Input: version1 = "1.0.1", version2 = "1" 
 * Output: 1 
 * 
 * Example 3:
 * 
 * Input: version1 = "7.5.2.4", version2 = "7.5.3" 
 * Output: -1
 * 
 * @author jfqiao
 *
 */
public class CompareVersionNumber {
	public int compareVersion(String version1, String version2) {
		int version1Start = 0;
		int version2Start = 0;
		int version1End = 0;
		int version2End = 0;
		while (true) {
			version1End = version1.indexOf(".", version1Start);
			if (version1End == -1) {
				version1End = version1.length();
			}
			version2End = version2.indexOf(".", version2Start);
			if (version2End == -1) {
				version2End = version2.length();
			}
			String s1 = version1.substring(version1Start, version1End);
			String s2 = version2.substring(version2Start, version2End);
			int version1Int;
			int version2Int;
			if (s1.length() == 0) {
				version1Int = 0;
			} else {
				version1Int = Integer.parseInt(s1);
			}
			if (s2.length() == 0) {
				version2Int = 0;
			} else {
				version2Int = Integer.parseInt(s2);
			}
			if (version1Int > version2Int)
				return 1;
			else if (version1Int < version2Int)
				return -1;
			if (version1End == version1.length() && version2End == version2.length())
				break;
			version1Start = version1End == version1.length() ? version1End : version1End + 1;
			version2Start = version2End == version2.length() ? version2End : version2End + 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String version1 = "7.5.2.4";
		String version2 = "7.5.3";
		System.out.println(new CompareVersionNumber().compareVersion(version1, version2));
	}
	
}
