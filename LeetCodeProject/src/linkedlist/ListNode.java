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
	
}