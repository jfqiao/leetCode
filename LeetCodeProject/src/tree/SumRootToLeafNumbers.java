package tree;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * 
 * 题目的描述没有问题，但是很容易产生误解，比如  1 -> 12 -> 3,
 * 这条路径产生的结果是（1 * 10 + 12 ) * 10 + 3 = 223, 而不是1123，
 * 所以不要被误解了，不是有字符串叠加产生的。
 * @author jfqiao
 *
 */
public class SumRootToLeafNumbers {
    private int sum;
	public int sumNumbers(TreeNode root) {
		sum = 0;
	    sumRecursive(root, 0);
        return sum;
    }
	
	//preSum表示父节点得到的路径值
	public void sumRecursive(TreeNode root, int preSum) {
		if (root == null) {
			return;
		}
		int val = preSum * 10 + root.val;
		//如果是叶子节点，加上路径值
		if (root.left == null && root.right == null) {
			sum += val;
			return;
		}
		sumRecursive(root.left, val);
		sumRecursive(root.right, val);
	}
}
