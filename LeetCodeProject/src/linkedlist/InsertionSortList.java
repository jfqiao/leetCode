package linkedlist;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author hgf
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode tail = head;
		while (tail != null) {
			ListNode tmp = head;
			while (tail.val >= tmp.val && tail != tmp) {
				tmp = tmp.next;
			}
			
		}
		return null;
	}
}
