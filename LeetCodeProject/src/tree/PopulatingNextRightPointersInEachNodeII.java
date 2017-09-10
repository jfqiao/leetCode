package tree;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * @author jfqiao
 *
 */
public class PopulatingNextRightPointersInEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PopulatingNextRightPointersInEachNode pn = new PopulatingNextRightPointersInEachNode();
		PopulatingNextRightPointersInEachNodeII pni = new PopulatingNextRightPointersInEachNodeII();
		TreeLinkNode[] ts = new TreeLinkNode[8];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new TreeLinkNode(i + 1);
		}
		ts[0].setChild(ts[1], ts[2]);
		ts[1].setChild(ts[3], ts[4]);
		ts[2].setChild(null, ts[5]);
		ts[3].setChild(ts[6], null);
		ts[5].setChild(null, ts[7]);
		TreeLinkNode root = ts[0];
		pni.connect2(root);
		pn.levelorder(root);
	}
	
    public void connect(TreeLinkNode root) {
    	if (root == null)
    		return;
    	int depth = depth(root);
    	for (int i = 2; i <= depth; i++) {
    		setNext(root, i);
    	}
    } 
    
    public int depth(TreeLinkNode root) {
    	if (root == null)
    		return 0;
    	int leftDepth = depth(root.left);
    	int rightDepth = depth(root.right);
    	return Math.max(leftDepth, rightDepth) + 1;
    }
    
    //这个算法不好，时间复杂度较高，思想如下：
    //对于每个root节点，都有两个子树，找到子树在相同层次的最左节点(对于右子树）
    //最右节点（对于左子树），将最右节点的next设置为最左节点即可。如果没有找到
    //则可以返回，两棵树不是一样高。递归节点即可。
    public void setNext(TreeLinkNode root, int level) {
    	if (root == null)
    		return;
    	TreeLinkNode left = root.left, right = root.right;
    	if (depth(root) < level)
    		return;
    	left = findSubTreeLeft(left, level - 1);
    	right = findSubTreeRight(right, level - 1);
    	if (left != null && right != null)
			left.next = right;
    	setNext(root.left, level);
    	setNext(root.right, level);
    }
    
    //找到左子树上最靠右的节点
    public TreeLinkNode findSubTreeLeft(TreeLinkNode root, int level) {
    	if (level == 1 || root == null )
    		return root;
    	TreeLinkNode right = findSubTreeLeft(root.right, level - 1);
    	if (right == null)
    		right = findSubTreeLeft(root.left, level - 1);
    	return right;
    }
    
    //找到右子树上最靠左的节点
    public TreeLinkNode findSubTreeRight(TreeLinkNode root, int level) {
    	if (level == 1 || root == null)
    		return root;
    	TreeLinkNode left = findSubTreeRight(root.left, level - 1);
    	if (left == null)
    		left = findSubTreeRight(root.right, level - 1);
    	return left;
    }
    
    //这个算法巧妙之处在于假设root层已经对next节点安排好了，
    //则对于下一层的左右子树来说，next节点的安排显而易见。只要找到root中next节点
    //中第一个出现的子节点即可。
    public void connect2(TreeLinkNode root) {
    	if (root == null)
    		return;
    	if (root.left != null) {
    		root.left.next = root.right == null ? findNextLeft(root.next) : root.right;
    	}
    	if (root.right != null) {
    		root.right.next = findNextLeft(root.left);
    	}
    	connect2(root.left);
    	connect2(root.right);
    }
    
    private TreeLinkNode findNextLeft(TreeLinkNode root) {
    	while (root != null) {
    		if (root.left != null) 
    			return root.left;
    		if (root.right != null)
    			return root.right;
    		root = root.next;
    	}
    	return null;
    }
}
