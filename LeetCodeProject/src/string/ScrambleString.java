package string;

/**
 * Problem description: Given a string s1, we may represent it as a binary tree
 * by partitioning it to two non-empty substrings recursively. Below is one
 * possible representation of s1 = "great": <br>
 * <code>
    great                               <br>
   /    \                               <br>
  gr    eat                             <br>
 / \    /  \							<br>
g   r  e   at							<br>
           / \							<br>
          a   t							<br></code>
 *
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children. For example, if we choose the node "gr" and swap its two children,
 * it produces a scrambled string "rgeat". <br>
 * rgeat <br>
 * / \ <br>
 * rg eat <br>
 * / \ / \ <br>
 * r g e at <br>
 * / \ <br>
 * a t <br>
 *
 * We say that "rgeat" is a scrambled string of "great". Similarly, if we
 * continue to swap the children of nodes "eat" and "at", it produces a
 * scrambled string "rgtae". <br>
 * rgtae <br>
 * / \ <br>
 * rg tae <br>
 * / \ / \ <br>
 * r g ta e <br>
 * / \ <br>
 * t a <br>
 * We say that "rgtae" is a scrambled string of "great". Given two strings s1
 * and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * @author jfq
 *
 */
public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.scrambelNumber("ab"));
	}

	public boolean isScramble(String s1, String s2) {

		return false;
	}

	//
	public int scrambelNumber(String s) {
		return scrambelNumberRecursive(s.length());
	}

	private int scrambelNumberRecursive(int n) {
		if (n <= 1)
			return 1;
		int result = 0;
		for (int i = 1; i < n; i++) {
			result += scrambelNumberRecursive(i) * scrambelNumberRecursive(n - i) * 2;
		}
		//会有重复的问题,暂时没有解决
		return result;
	}
}
