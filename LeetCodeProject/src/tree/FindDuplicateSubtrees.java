package tree;

import java.util.List;
import java.util.ArrayList;

public class FindDuplicateSubtrees {
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		List<TreeNode> listInt = new ArrayList<>();
		traverse(listInt, root);
		boolean[] isVisit = new boolean[listInt.size()];
		for (int i = 1; i < listInt.size(); i++) {
			if (isVisit[i])
				continue;
			int j = i + 1;
			int tmp = 0;
			while (j < listInt.size()) {
				int dupPos = findDuplicate(listInt, j, listInt.get(i));
				if (dupPos > -1 && isSameTree(listInt.get(i), listInt.get(dupPos))) {
					if (tmp == 0)
						list.add(listInt.get(i));
					tmp++;
					isVisit[dupPos] = true;
				}
				if (dupPos == -1)
					break;
				
				j = dupPos + 1;
			}
		}
		return list;
	}

	public void traverse(List<TreeNode> list, TreeNode root) {
		if (root != null) {
			list.add(root);
			traverse(list, root.left);
			traverse(list, root.right);
		}
	}

	public int findDuplicate(List<TreeNode> list, int start, TreeNode cur) {
		for (int i = start; i < list.size(); i++) {
			if (list.get(i).val == cur.val) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isSameTree(TreeNode left, TreeNode right) {
		if (left == null | right == null) {
			if (left == null && right != null
					|| left != null && right == null)
				return false;
			return true;
		}
		if (left.val != right.val)
			return false;
		return isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
	}
}
