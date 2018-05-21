package tree;

/**
 * 
 * @author jfqiao
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 *
 */

import java.util.List;
import java.util.ArrayList;


public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		TreeNode root = TreeNode.genTree();
		BinaryTreeRightSideView btrs = new BinaryTreeRightSideView();
		List<Integer> list = btrs.rightSideView(root);
		System.out.println(list);
	}
	
	// 如果采用层次遍历的方法可以直接解决问题。不采用层次遍历的方法。二叉树的经典方法：分左右子树进行讨论。
	// 这个还不如用层次遍历快。
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		List<Integer> left = null;
		List<Integer> right = null;
		if (root.left != null)
			left = rightSideView(root.left);
		if (root.right != null)
			right = rightSideView(root.right);
		if (right != null) {
			list.addAll(right);
			if (left != null && right.size() < left.size()) {
				for (int i = right.size(); i < left.size(); i++) {
					list.add(left.get(i));
				}
			}
		}
		else if (left != null) 
			list.addAll(left);
		list.add(0, root.val);
		return list;
	}
	
	
}
