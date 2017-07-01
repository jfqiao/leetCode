package dynamicprogramming;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author jfqiao
 *
 */
public class UniqueBinarySearchTree {
	private int[] nums;
	public static void main(String[] args) {
		UniqueBinarySearchTree ubst = new UniqueBinarySearchTree();
	    System.out.println(ubst.numTrees(5));
	}
	
	public int numTrees(int n) {
		nums = new int[n];
		return numTreesRecursive(n);
	}
	
	public int numTreesRecursive(int n) {
		if (n > 0 && nums[n - 1] > 0)
			return nums[n - 1];
		if (n <= 1) {
			if (n > 0)nums[n - 1] = 1;
			return 1;
		}
		int result = 0;
		for (int i = 0; i < n; i++) 
			result += numTreesRecursive(i) * numTreesRecursive(n - 1 - i);
		nums[n - 1] = result;
		return result;
	}
	

}
