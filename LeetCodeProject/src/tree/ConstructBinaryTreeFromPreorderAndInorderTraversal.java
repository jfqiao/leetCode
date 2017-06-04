package tree;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author hgf
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	private int[] inorder;
	private int[] preorder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstructBinaryTreeFromPreorderAndInorderTraversal c = 
				new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		
		int[] preorder = {1, 2, 4, 8, 9, 12, 13, 5, 3, 6, 10, 11, 7};
		int[] inorder = {8, 4, 12, 9, 13, 2, 5, 1, 10, 6, 11, 3, 7};
		TreeNode node = c.buildTree(preorder, inorder);
		System.out.println(node.val);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.inorder = inorder;
		this.preorder = preorder;
		return construct(0, preorder.length - 1, 0);
	}
	
	//一般要处理搜索到-1, test case 中确保不会出现这种情况。
	public int search(int[] nums, int target, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}
	/**
	 * 采用二分法分割中序遍历序列，
	 * pos表示先序遍历数组中当前访问节点的位置，通过在中序遍历表中查找该值，得到中序位置，
	 * 由此将一棵树分割为三部分，根节点，左子树，右子树。 
	 * 左子树在中序表中范围是当前start到当前根节点在中序表位置（不包括）
	 * 右子树在中序表中范围是当前跟节点在中序表位置（不包括）到end
	 * @param start    当前树在中序遍历表中开始位置（包含）
	 * @param end	         当前树在中序遍历表中的结束位置（包含）
	 * @param pos      当前跟节点在中序遍历表的位置
	 * @return         当前树的根节点
	 */
	public TreeNode construct(int start, int end,int pos) {
		TreeNode node = null;
		if (start <= end){
			node = new TreeNode(preorder[pos]);
			int inorderPos = search(inorder, preorder[pos], start, end);
			node.left = construct(start, inorderPos - 1, 
					pos + 1);
			node.right = construct(inorderPos + 1, end, 
				    pos + inorderPos - start + 1);
		}
		return node;
	}

}
