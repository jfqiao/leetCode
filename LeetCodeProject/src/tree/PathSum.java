package tree;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		PathSum ps = new PathSum();
		System.out.println(ps.hasPathSum(null, 0));
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return pathSumRecursive(root, sum, 0);
    }
	
	public boolean pathSumRecursive(TreeNode root, int sum, int tmpSum) {
		if (root.left == null && root.right == null) {
			if (root.val + tmpSum == sum)
				return true;
			return false;
		}
		if (root.left!= null && pathSumRecursive(root.left,sum, tmpSum + root.val))
			return true;
		if (root.right != null && pathSumRecursive(root.right, sum, tmpSum + root.val))
			return true;
		return false;
	}
	

}
