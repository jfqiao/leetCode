package tree;

import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author hgf
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		ConvertSortedArrayToBinarySearchTree csabs = new ConvertSortedArrayToBinarySearchTree();
		TreeNode root = csabs.sortedArrayToBST(nums);
		BinaryTreeLevelOrderTraversal btit = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> list = btit.levelOrder(root);
		for (List<Integer> l : list) {
			for (int i : l)
				System.out.print(i + "\t");
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}
	
	public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int middle = (start + end) / 2;
		TreeNode root = new TreeNode(nums[middle]);
		root.left = sortedArrayToBST(nums, start, middle - 1);
		root.right = sortedArrayToBST(nums, middle + 1, end);
		return root;
	}
}
