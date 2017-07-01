package tree;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution?
 * 
 * @author jfqiao
 * 
 */
public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		RecoverBinarySearchTree rbst = new RecoverBinarySearchTree();
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		rbst.recoverTree2(t1);
	}

	public void recoverTree(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		inorderIterative(root, list);
		TreeNode first = null, last = null;
		int firstPos = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			int j = i + 1;
			if (list.get(i).val > list.get(j).val) {
				if (first == null) {
					firstPos = i;
					first = list.get(i);
					continue;
				}
				last = list.get(j);
			}
		}
		if (last == null)
			last = list.get(firstPos + 1);
		int tmp = last.val;
		last.val = first.val;
		first.val = tmp;
	}

	private void inorderIterative(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		while (!stack.empty()) {
			TreeNode p = stack.pop();
			list.add(p);

			if (p.right == null)
				continue;

			TreeNode q = p.right;
			while (q != null) {
				stack.push(q);
				q = q.left;
			}

		}
	}

	//使用O(1)的空间复杂度。
	private void recoverTree2(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		TreeNode first = null, next = null;
		TreeNode errorNode1 = null, errorNode2 = null, errorNodeNext = null;
		while (!stack.empty()) {
			TreeNode p = stack.pop();
			if (first == null)
				first = p;
			else {
				next = p;
			}
			if (first != null && next != null) {
				if (first.val > next.val) {
					if (errorNode1 == null) {
					errorNode1 = first;
					errorNodeNext = next;
					}
					else {
						errorNode2 = next;
					}
				} 
					
			}
			if (next != null)
				first = next;
			// next = null;
			if (p.right == null)
				continue;

			TreeNode q = p.right;
			while (q != null) {
				stack.push(q);
				q = q.left;
			}

		}
		if (errorNode2 == null)
			errorNode2 = errorNodeNext;
		int tmp = errorNode1.val;
		errorNode1.val = errorNode2.val;
		errorNode2.val = tmp;
	}
}
