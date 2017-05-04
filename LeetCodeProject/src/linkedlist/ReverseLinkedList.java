package linkedlist;

/**
 * Problem description: Reverse a singly linked list.
 * 
 * @author jfq
 * 
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode head = ListNode.generateListNode();
		ReverseLinkedList rll = new ReverseLinkedList();
		head = rll.reverseList(head);
		ListNode.output(head);
	}

	// iterative
	public ListNode reverseList(ListNode head) {
		ListNode hail = head;
		ListNode p = new ListNode(0);
		ListNode q = head, r;
		while (q != null) {
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}
		if (hail != null)
			hail.next = null;
		return p;
	}

	// 迭代的方法与递归没有大的区别，直接替换即可。
}
