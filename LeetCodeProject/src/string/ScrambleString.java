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
 * rgeat                     <br>
 * / \                       <br>
 * rg eat					 <br>
 * / \ / \					 <br>
 * r g e at 				 <br>
 * / \ 						 <br>
 * a t 						 <br>
 *
 * We say that "rgeat" is a scrambled string of "great". Similarly, if we
 * continue to swap the children of nodes "eat" and "at", it produces a
 * scrambled string "rgtae". <br>
 * rgtae 							<br>
 *  / \								<br>
 * rg  tae 					   	 	<br>
 * / \  / \							<br>
 * r g ta e 				    	<br>
 *     /\ 							<br>
 *    t  a 							<br>
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
		System.out.println(ss.scrambelNumber("abcde"));
	}
	
	// 动态规划思想：将原问题分解为子问题。
	//原字符串的长度为 n, 可以将字符串分为 i, j 两段， 1 <= i, j <= n - 1
	//这两段形成自己的混合字符串，分两种情况组合：
	// 1. 交换位置组合
	// 2. 不交换位置组合
	//组合得到的结果与s2比较即可。（消耗内存比较大）。	
	public boolean isScramble(String s1, String s2) {
		
		return false;
	}

	//
	public int scrambelNumber(String s) {
		int n = s.length();
		int result = 0;
		for (int i = 1; i < n; i++) {
			result += scrambelNumberRecursive(i, n - i);
		}
		return result;
	}

	private int scrambelNumberRecursive(int i, int j) {
		if (i == 1 && j == 1)
			return 2;
		int resultLeft = 0;
		int resultRight = 0;
		for (int k = 1; k < j; k++)
			resultRight += scrambelNumberRecursive(k, j - k);
		for (int k = 1; k < i; k++)
			resultLeft += scrambelNumberRecursive(k, i - k);
		if (resultLeft == 0)
			return 2 * resultRight;
		if (resultRight == 0)
			return 2 * resultLeft;
		return 2 * resultLeft * resultRight;
	}
}
