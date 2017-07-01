package tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * problem description: Given a binary tree, return the inorder traversal of its
 * nodes' values.
 * 
 * For example: Given binary tree [1,null,2,3],
 *  1 
 *  \ 
 *  2 
 *  / 
 *  3 
 *  return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author hgf
 *
 */

public class BinaryTreeInorderTraverse {

	public static void main(String[] args) {
		BinaryTreeInorderTraverse bti = new BinaryTreeInorderTraverse();
		TreeNode root = TreeNode.genTree();
		bti.inorderTraversal(root);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorderIterative(root, list);
		return list;
	}

	public void inorderRecursive(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorderRecursive(root.left, list);
		list.add(root.val);
		inorderRecursive(root.right, list);
	}

	private void inorderIterative(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		
		while (!stack.empty()) {
			TreeNode p = stack.pop();
			list.add(p.val);
			
			if (p.right == null)
				continue;
			
			TreeNode q = p.right;
			while (q != null) {
				stack.push(q);
				q = q.left;
			}
	
		}
	}
}
