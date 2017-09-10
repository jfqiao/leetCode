package tree;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * @author hgf
 *
 */
public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        levelOrderDFS(list, 0, root);
        return list;
    }
	
	public void levelOrderDFS(List<List<Integer>> list, int level,
			TreeNode root) {
		if (root == null) {
			return;
		}
		if (list.size() < level + 1) {
//			List<Integer> tmpList = new ArrayList<Integer>();
//			tmpList.add(root.val);
			list.add(0, new ArrayList<Integer>());
		}
//		else {
		list.get(list.size() - level - 1).add(root.val);
//		}
		levelOrderDFS(list, level + 1, root.left);
		levelOrderDFS(list, level + 1, root.right);
	}
}
