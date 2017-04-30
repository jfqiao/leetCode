package linkedlist;

public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII rdfsl = new RemoveDuplicatesFromSortedListII();
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
		// 为head添加一个开头，使得所有的判断从p后面开始。
		ListNode p = new ListNode(0);
		// p 是前一个节点，q 是当前节点，r是用来移动的节点
		p.next = head;
		ListNode q, r;
		int first = 0;
		boolean add = false;
		while (p != null) {
			q = p.next;
			r = q;
			// 如果当前节点与移动节点的后一个节点值相同，r向后移动一个节点。
			// 这里使得q 到 r 是重复节点序列
			while (q != null && r.next != null && q.val == r.next.val)
				r = r.next;
			// 判断q到r是否为重复序列，是直接跳过，进行下一次循环，不是添加到链表中。
			if (q != r && q.val == r.val) {
				p.next = r.next;
				add = false;
			} else
				add = true;
			if (first == 0) {
				head = p;
			}
			first++;
			if (add)
				p = p.next;
		}
		return head.next;
	}
}