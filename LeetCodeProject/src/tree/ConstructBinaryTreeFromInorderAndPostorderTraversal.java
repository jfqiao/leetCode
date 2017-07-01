package tree;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	private int[] postorder;
	private int[] inorder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.inorder = inorder;
		this.postorder = postorder;
		return construct(0, inorder.length - 1, inorder.length - 1);
	}
	
	public int search(int[] nums, int target, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}
	/*
	 * 算法原理同用先序表以及中序表构建二叉树树相同，
	 * start, end描述中序表中树节点所占位置，
	 * pos表示后续表中根节点的位置，
	 * 返回树的根节点。
	 */
	public TreeNode construct(int start, int end,int pos) {
		TreeNode node = null;
		if (start <= end){
			node = new TreeNode(postorder[pos]);
			int inorderPos = search(inorder, postorder[pos], start, end);
			//后续表遍历中，当前节点的左子树根节点位于跨过右子树节点后的第一个节点
			node.left = construct(start, inorderPos - 1,
					pos - (end - inorderPos + 1));
			//后续表遍历中，当前节点的右子树根节点位于当前节点左侧第一个节点
			node.right = construct(inorderPos + 1, end, 
				    pos - 1);
		}
		return node;
	}
}
