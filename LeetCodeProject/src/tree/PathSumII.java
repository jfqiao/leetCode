package tree;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author jfqiao
 *
 */
public class PathSumII {
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return new ArrayList<List<Integer>>();
		List<List<Integer>> list = pathSumRecursive(root, sum, 0);
		if (list == null)
			return new ArrayList<List<Integer>>();
		return list;
    }
	
	public List<List<Integer>> pathSumRecursive(TreeNode root, int sum, int tmpSum) {
		if (root.left == null && root.right == null) {
			if (tmpSum + root.val == sum) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(root.val);
				List<List<Integer>> result = new ArrayList<List<Integer>>();
				result.add(list);
				return result;
			}
		}
		List<List<Integer>> listLeft = null;
		List<List<Integer>> listRight = null;
		if (root.left != null) {
			listLeft = pathSumRecursive(root.left, sum, tmpSum + root.val);
			if (listLeft != null) 
				for (List<Integer> l : listLeft)
					l.add(0, root.val);
		}
		if (root.right != null) {
			listRight = pathSumRecursive(root.right, sum, tmpSum + root.val);
			if (listRight != null)
				for (List<Integer> l : listRight)
					l.add(0, root.val);
		}
		if (listLeft == null)
			return listRight;
		if (listRight != null)
			listLeft.addAll(listRight);
		return listLeft;
	}
}
