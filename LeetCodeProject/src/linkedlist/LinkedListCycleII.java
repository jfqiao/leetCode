package linkedlist;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author jfq
 *
 */

public class LinkedListCycleII {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		head.next = node2;
//		node2.next = head;
		LinkedListCycleII llc = new LinkedListCycleII();
		System.out.println(llc.detectCycle(node2));
	}

	public ListNode detectCycle(ListNode head) {
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		ListNode fast = preHead, slow = preHead;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				fast = slow;
				slow = preHead;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
					if (fast == slow)
						return fast;
				}
			}
		}
		return null;
	}
}
