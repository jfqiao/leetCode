package tree;

public class TreeLinkNode {
	public int val;
	public TreeLinkNode left, right, next;

	public TreeLinkNode(int x) {
		val = x;
	}
	
	public void setChild(TreeLinkNode left, TreeLinkNode right) {
		this.left = left;
		this.right = right;
	}
}
