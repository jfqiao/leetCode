package tree;

import java.util.Stack;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

 * @author jfqiao
 *
 */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//按中序遍历应该时产生一个有序数组，否则不是一个valid BST
    public boolean isValidBST(TreeNode root) {
    	return inorderIterative(root);
    }
    
    private boolean inorderIterative(TreeNode root) {
		if (root == null)
			return false;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		Long val = Long.MIN_VALUE;
		while (!stack.empty()) {
			TreeNode p = stack.pop();
			if (p.val > val)  //不能使用 大于或等于，但是p.val有可能等于Integer.MIN_VALUE,此时可等于
				val = (long) p.val; //因此有两种思路：1 val 升为long型，2 对第一次进行判断  
			else
				return false;
			
			if (p.right == null)
				continue;
			
			TreeNode q = p.right;
			while (q != null) {
				stack.push(q);
				q = q.left;
			}
		}
		return true;
	}

}
