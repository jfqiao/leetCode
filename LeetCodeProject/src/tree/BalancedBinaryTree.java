package tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author hgf
 *
 */
public class BalancedBinaryTree {
	
	public boolean isBalanced2(TreeNode root) {
        if (root == null)
            return  true;
        return isBalancedRecursive(root) >= 0;
    }
	   public boolean isBalanced(TreeNode root) {
	        if (root == null)
	            return  true;
	        return Math.abs(height(root.left) - height(root.right)) <= 1
	        		&& isBalanced(root.left) && isBalanced(root.right);
	                
	    }
	    
	    public int height(TreeNode root) {
	        if (root == null)
	            return 0;
	        return Math.max(height(root.left), height(root.right)) + 1;
	    }
	    
	    /*
	     * 一边迭代高度一遍判断是否为平衡二叉树.
	     */
	    public int isBalancedRecursive(TreeNode root) {
	    	if (root == null)
	    		return 0;
	    	int leftHeight = isBalancedRecursive(root.left);
	    	int rightHeight = isBalancedRecursive(root.right);
	    	if (leftHeight < 0 || rightHeight < 0)
	    		return -1;
	    	if (Math.abs(leftHeight - rightHeight) >= 1)
	    		return -1;
	    	return Math.max(leftHeight, rightHeight) + 1;
	    }
}	
