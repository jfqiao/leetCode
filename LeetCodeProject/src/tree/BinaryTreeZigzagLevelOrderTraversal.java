package tree;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author jfqiao
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	private List<List<Integer>> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//稍微调整下层次访问的方法，队列改为栈，再稍微调整下压栈顺序即可。
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	list = new ArrayList<List<Integer>>();
    	Stack<TreeNode> queue1 = new Stack<TreeNode>();
		Stack<TreeNode> queue2 = new Stack<TreeNode>();
		List<Integer> tmp = null;
		if (root != null)
			queue1.add(root);
		boolean reverse = true;
		while (true) {
			if (queue1.isEmpty() && queue2.isEmpty())
				break;
			//处理偶数层（从第0层开始）
			if (reverse) {
				if (tmp == null)
					tmp = new ArrayList<Integer>();
				TreeNode node = queue1.pop();
				tmp.add(node.val);
				if (node.left != null)
					queue2.push(node.left);
				if (node.right != null)
					queue2.push(node.right);
				if (queue1.isEmpty()) {
					list.add(tmp);
					tmp = null;
					reverse = false;
				}
			}
			//处理奇数层
			else {
				TreeNode node = queue2.pop();
				if (tmp == null)
					tmp = new ArrayList<Integer>();
				tmp.add(node.val);
				//压栈顺序调整下
				if (node.right != null)
					queue1.push(node.right);
				if (node.left != null) 
					queue1.push(node.left);
				if (queue2.isEmpty()) {
					reverse = true;
					list.add(tmp);
					tmp = null;
				}
			}
		}
        return list;
    }

}
