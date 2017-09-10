package tree;

import linkedlist.ListNode;
import java.util.List;
import java.util.ArrayList;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author hgf
 *
 */
public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode l = new ListNode(0);
		l.next = l1;
		ConvertSortedListToBinarySearchTree csabs = new ConvertSortedListToBinarySearchTree();
		TreeNode t = csabs.sortedListRecursive(l, (ListNode)null); 
		System.out.println(t.val);
	}

	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return sortedArrayToBST(list, 0, list.size() - 1);
	}
	
	public TreeNode sortedArrayToBST(List<Integer> nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int middle = (start + end) / 2;
		TreeNode root = new TreeNode(nums.get(middle));
		root.left = sortedArrayToBST(nums, start, middle - 1);
		root.right = sortedArrayToBST(nums, middle + 1, end);
		return root;
	}
	
	public TreeNode sortedListRecursive(ListNode head, ListNode tail) {
		ListNode middle = fastPointer(head, tail);
		if (middle == null)
			return null;
		TreeNode root = new TreeNode(middle.val);
		root.left = sortedListRecursive(head, middle);
		root.right = sortedListRecursive(middle, tail);
		return root;
	}
	
	public ListNode fastPointer(ListNode head, ListNode tail) {
		if (head.next == null || head.next == tail)
			return null;
		ListNode fast = head.next;
		ListNode slow = head.next;
		while (fast != null && fast.next != null 
				&& fast.next != tail && fast.next.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
