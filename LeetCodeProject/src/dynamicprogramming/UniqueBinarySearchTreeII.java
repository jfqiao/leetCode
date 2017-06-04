package dynamicprogramming;

import java.util.List;
import java.util.Stack;

import tree.TreeNode;

import java.util.ArrayList;
/**
 * Problem description:
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author jfqiao
 *
 */
public class UniqueBinarySearchTreeII {
	List<TreeNode> list;
	TreeNode[] trees;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     UniqueBinarySearchTreeII ubs = new UniqueBinarySearchTreeII();
     List<TreeNode> list = ubs.generateTrees(3);
     System.out.println(list.size());
     for (TreeNode node : list) {
    	 ubs.inorderIterative(node);
    	 System.out.println();
     }
	}
	
	public List<TreeNode> generateTrees(int n) {
		trees = new TreeNode[n];
		list = new ArrayList<TreeNode>();
		list = generateTreeRecursive(n);
		return list;
	}
	
	public List<TreeNode> generateTreeRecursive(int n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (n == 0) {
			list.add(null);
			return list;
		}
		if (n == 1) {
			TreeNode node = new TreeNode(1);
			list.add(node);
			return list;
		}
		
		for (int i = 0; i < n; i++) {
			List<TreeNode> left = generateTreeRecursive(i);
			List<TreeNode> right = generateTreeRecursive(n - 1 - i);
			for (int l = 0; l < left.size(); l++) {
				for (int r = 0; r < right.size(); r++) {
					TreeNode node = new TreeNode(1);
					node.left = left.get(l);
					node.right = right.get(r);
					list.add(node);
				}
			}
		}
		return list;
	}
	
	private void inorderIterative(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		int count = 1;
		while (!stack.empty()) {
			TreeNode p = stack.pop();
//			p.val -= gap
			p.val = count++;
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
