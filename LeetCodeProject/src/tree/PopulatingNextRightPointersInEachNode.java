package tree;

/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * @author jfqiao
 */
public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersInEachNode pn = new PopulatingNextRightPointersInEachNode();
		TreeLinkNode[] ts = new TreeLinkNode[31];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new TreeLinkNode(i + 1);
		}
		for (int i = 0; i < ts.length / 2; i++) {
			ts[i].left = ts[2 * i + 1];
			ts[i].right = ts[2 * i + 2];
		}
		TreeLinkNode root = ts[0];
		pn.preorder(ts[0]);
		pn.connect(ts[0]);
		System.out.println();
		pn.levelorder(root);
	}
	
	public void connect(TreeLinkNode root) {
        if (root == null || root.left == null)
        	return;
        setLeftToRight(root.left, root);
        setLeftToRight(root.right, root);
        root.left.next = root.right;
        int depth = depth(root);
        for (int i = 3; i <= depth; i++) {
        	setRightToLeft(root, i);
        }
    }
	
	public void setLeftToRight(TreeLinkNode root, TreeLinkNode parent) {
		if (root == null)
			return;
		if (root == parent.left)
			root.next = parent.right;
		setLeftToRight(root.left, root);
		setLeftToRight(root.right, root);
	}
	
	public int depth(TreeLinkNode root) {
		int depth = 0;
		while (root != null) {
			depth++;
			root = root.left;
		}
		return depth;
	}
	
	public void setRightToLeft(TreeLinkNode root, int level) {
		if(root == null)
			return;
		if (depth(root) < level)
			return;
		TreeLinkNode left = root.left, right = root.right;
		int tmpLevel = level; 
		while (tmpLevel > 2 && left != null && right != null) {
			left = left.right;
			right = right.left;
			tmpLevel--;
		}
		if (left != null && right != null)
			left.next = right;
		setRightToLeft(root.left, level);
		setRightToLeft(root.right, level);
	}
	
	public void preorder(TreeLinkNode root) {
		if (root == null)
			return;
		System.out.print(root.val + "\t");
		preorder(root.left);
		preorder(root.right);
	}
	
	public void levelorder(TreeLinkNode root) {
		while (root != null) {
			TreeLinkNode tmp = root;
			while (root != null) {
				System.out.print(root.val + "\t");
				root = root.next;
			}
			root = tmp.left;
		}
	}
}
