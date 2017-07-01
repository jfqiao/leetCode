package tree;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 * @author jfqiao
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(3);
		t1.setChild(t2, t3);
		t2.setChild(t4, t5);
		t3.setChild(t6, t7);
		SymmetricTree st = new SymmetricTree();
		System.out.println(st.isSymmetric(t1));
	}
	
	public boolean isSymmetric(TreeNode root) {
        if (root == null)
        	return true;
       return isSymmetricIterative(root);
    }
	
	public boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
		if (left == null) {
			if (right == null)
				return true;
			return false;
		}
		if (right == null || left.val != right.val)
			return false;
		return isSymmetricRecursive(left.left, right.right)
			&& isSymmetricRecursive(left.right, right.left);
	}
	
	//迭代法
	public boolean isSymmetricIterative(TreeNode root) {
		Stack<TreeNode> stackLeft = new Stack<TreeNode>();
		Stack<TreeNode> stackRight = new Stack<TreeNode>();
		TreeNode left = root.left, right = root.right;
		if (!leftCompare(left, right, stackLeft, stackRight))
			return false;
		while (!stackLeft.empty() && !stackRight.empty()) {
			left = stackLeft.pop();
			right = stackRight.pop();
			if (!leftCompare(left, right, stackLeft, stackRight))
				return false;
		}
		return true;
	}

	public boolean leftCompare(TreeNode left, TreeNode right,
			Stack<TreeNode> stackLeft, Stack<TreeNode>stackRight) {
		while (left != null || right != null) {
			if (left == null && right != null ||
					left != null && right == null ||
					left .val != right.val)
				return false;
			stackLeft.add(left.right);
			stackRight.add(right.left);
			left = left.left;
			right = right.right;
		}
		return true;
	}
	
}
