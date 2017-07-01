package linkedlist;

/**
 * Problem description: Given a linked list and a value x, partition it such
 * that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author jfqiao
 *
 */

public class PartitionList {
	
	//已经AC。
	public ListNode partition(ListNode head, int x) {
		ListNode small = new ListNode(0);
		ListNode smallHead = small;
		ListNode large = new ListNode(0);
		ListNode largeHead = large;
//		ListNode tmp = null;
		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			}
			else {
				large.next = head;
				large = large.next;
			}
//			tmp = head.next;
//			head.next = null;
//			head = tmp;
			head = head.next;
		}
		small.next = largeHead.next;
		large.next = null;
		return smallHead.next;
    }
}
