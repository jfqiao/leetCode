package string;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 * @author jfqiao
 *
 */
import java.util.Map;
import java.util.HashMap;

public class IsomorphicStrings {
	public static void main(String[] args) {
		IsomorphicStrings is = new IsomorphicStrings();
		String s1 = "add";
		String s2 = "bcc";
		System.out.println(is.isIsomorphic(s1, s2));
	}
	
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Integer> smap = new HashMap<>();
		Map<Character, Integer> tmap = new HashMap<>();
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			Integer spos = smap.get(sc);
			Integer tpos = tmap.get(tc);
			if (spos == null && tpos == null) {
				smap.put(sc, count);
				tmap.put(tc, count);
				count++;
			}
			else if (spos == null || tpos == null || spos != tpos)
				return false;
		}
        return true;
    }
}
