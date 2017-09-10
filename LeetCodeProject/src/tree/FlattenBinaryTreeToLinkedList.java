package tree;

import java.util.List;
import java.util.ArrayList;
/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 * @author jfqiao
 *
 */
public class FlattenBinaryTreeToLinkedList {
	
	private List<TreeNode> list;
	
	//算法的目标就是按照先序遍历将节点串接起来
    public void flatten(TreeNode root) {
    	list = new ArrayList<TreeNode>();
    	for(int i = 0; i < list.size() - 1; i++) {
    		list.get(i).left = null;
    		list.get(i).right = list.get(i + 1);
    	}
    }
    
    public void preorder(TreeNode root) {
    	if (root == null)
    		return;
    	list.add(root);
    	preorder(root.left);
    	preorder(root.right);
    }
    
    public void flattenWithoutList(TreeNode root) {
    	
    }
}
