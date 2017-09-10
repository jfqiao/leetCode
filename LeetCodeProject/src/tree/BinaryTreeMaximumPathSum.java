package tree;

/**
 * Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * @author jfqiao
 *
 */
public class BinaryTreeMaximumPathSum {
	private int max;
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(-1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(-3);
		TreeNode n7 = new TreeNode(2);
		n1.setChild(n2, n3);
		n2.setChild(n4, n5);
		n3.setChild(n6, n7);
		BinaryTreeMaximumPathSum bs = new BinaryTreeMaximumPathSum();
		System.out.println(bs.maxPathSum(n1));
	}
	
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxPathSumRecursive(root);
		return max;
	}
	
	/*
	 * 最大路径有两种情形: (以下parent为根节点）
	 * 1.最大路径通过parent节点
	 * 2.最大路径不通过parent节点
	 * 对于通过parent节点，则计算左子树最大单向路径，右子树最大单向路径，加上跟节点值即可。
	 * （parent向上回退时，只需要一个最大单向路径，因此选择较大的即可。）
	 * 对于不通过parent节点，则分别计算左右子树的最大路径即可。
	 */
    public int maxPathSumRecursive(TreeNode root) {
    	if (root == null)
    		return 0;
    	int leftSum = maxPathSumRecursive(root.left);
    	int rightSum = maxPathSumRecursive(root.right);
    	leftSum = leftSum > 0 ? leftSum : 0;
    	rightSum = rightSum > 0 ? rightSum : 0;
    	int result = Math.max(leftSum, rightSum) + root.val;
    	root.val += leftSum + rightSum;
    	max = Math.max(root.val, max);
    	if (result < 0)
    		return 0;
    	return result;
    }
    
    
    
}
