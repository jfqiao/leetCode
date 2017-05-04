package linkedlist;

public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList rdfsl = new RemoveDuplicatesFromSortedList();
		ListNode head = ListNode.generateListNode();
		head = rdfsl.deleteDuplicates(head);
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
