package tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 * @author hgf
 *
 */

public class BinaryTreePreorderTraversal {
	private List<Integer> result;
	
	public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        preorderRecursive(root);
        return result;
    }
	
	public void preorderRecursive(TreeNode root) {
		if (root == null)
			return;
		result.add(root.val);
		preorderRecursive(root.left);
		preorderRecursive(root.right);
	}
	
	public void preorderIterative(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode node;
		while (!stack.empty()) {
			node = stack.pop();
			result.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
	}
}
