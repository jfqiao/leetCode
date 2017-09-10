package tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 * @author hgf
 *
 */

public class BinaryTreePostorderTraversal {
	private List<Integer> result;
	public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        if (root != null)
        	postorderRecursive(root);
        return result;
    }
	
	public void postorderRecursive(TreeNode root) {
		if (root.left != null)
			postorderRecursive(root.left);
		if (root.right != null)
			postorderRecursive(root.right);
		result.add(root.val);
	}
	
	public void postoederIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode node;
		while (!stack.empty()) {
			
		}
	}
}
