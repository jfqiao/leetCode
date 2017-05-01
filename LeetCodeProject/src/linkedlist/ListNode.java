package linkedlist;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public static void output(ListNode head) {
		while (head != null) {
			if (head.next != null)
				System.out.print(head.val + "->");
			else
				System.out.print(head.val);
			head = head.next;
		}
	}
	
	public static ListNode generateListNode() {
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
		return l1;
	}
}