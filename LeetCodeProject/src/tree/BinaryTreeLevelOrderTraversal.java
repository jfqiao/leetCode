package tree;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
 * @author jfqiao
 *
 */
public class BinaryTreeLevelOrderTraversal {
	private List<List<Integer>> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//使用队列可以解决按层次遍历的问题，
	//使用两个队列进行控制，一个记录父节点用于当前访问，一个用于记录子节点用于未来访问。
	//一旦父节点队列为空，转换两个队列的角色即可。
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> tmp = null;
		if (root != null)
			queue1.add(root);
		boolean reverse = true;
		while (true) {
			if (queue1.isEmpty() && queue2.isEmpty())
				break;
			if (reverse) {
				if (tmp == null)
					tmp = new ArrayList<Integer>();
				TreeNode node = queue1.poll();
				tmp.add(node.val);
				if (node.left != null)
					queue2.add(node.left);
				if (node.right != null)
					queue2.add(node.right);
				if (queue1.isEmpty()) {
					list.add(tmp);
					tmp = null;
					reverse = false;
				}
			}
			else {
				TreeNode node = queue2.poll();
				if (tmp == null)
					tmp = new ArrayList<Integer>();
				tmp.add(node.val);
				if (node.left != null) 
					queue1.add(node.left);
				if (node.right != null)
					queue1.add(node.right);
				if (queue2.isEmpty()) {
					reverse = true;
					list.add(tmp);
					tmp = null;
				}
			}
		}
        return list;
    }
	
	//另外一种采用深度优先的递归方式。
	//调用开始时level = 0.
	 public void levelOrderDFS(TreeNode root, int level) {
	    	if (root == null)
	    		return ;
	    	if (list.size() < level + 1) {
	    		list.add(new ArrayList<Integer>());
	    	}
	    	list.get(level).add(root.val);
	    	levelOrderDFS(root.left, level + 1);
	    	levelOrderDFS(root.right, level + 1);
	    }

}
