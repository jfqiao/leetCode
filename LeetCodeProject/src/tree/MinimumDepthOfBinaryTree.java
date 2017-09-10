package tree;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * @author jfqiao
 *
 */
public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		return minDepthRecursive(root);
	}
	
	private int minDepthRecursive(TreeNode root) {
		if (root.left == null && root.right == null) 
			return 1;
		int leftDepth = Integer.MAX_VALUE;
		int rightDepth = Integer.MAX_VALUE;
		if (root.left != null) {
			leftDepth = 1 + minDepth(root.left);
		}
		if (root.right != null) {
			rightDepth = 1 + minDepth(root.right);
		}
		if (leftDepth < rightDepth)
			return leftDepth;
		else
			return rightDepth;
	}
}
