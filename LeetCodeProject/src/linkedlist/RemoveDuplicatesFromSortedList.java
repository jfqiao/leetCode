package linkedlist;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList rdfsl = new RemoveDuplicatesFromSortedList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(5);
		ListNode l8 = new ListNode(5);
		ListNode l9 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		ListNode head = rdfsl.deleteDuplicates(null);
		ListNode.output(head);
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = new ListNode(0);
		p.next = head;
		ListNode q, r;
		int first = 0;
		while (p != null) {
			q = p.next;
			r = q;
			while (q != null && r.next != null && r.next.val == q.val)
				r = r.next;
			if (q != r && q.val == r.val)
				p.next = r;
			if (first == 0)
				head = p;
			first = 1;
			p = p.next;
		}
		return head.next;
	}
}
