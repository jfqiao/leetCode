package tree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) {
		this.val = x;
	}
	
	static TreeNode genTree() {
		TreeNode n = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		n.setChild(n1, n2);
		n1.setChild(n3, n4);
		n2.setChild(n5, n6);
		n4.setChild(n7, n8);
		n7.setChild(n9, null);
		return n;
	}
	
	public void setChild(TreeNode left, TreeNode right) {
		this.left = left;
		this.right = right;
	}
}
