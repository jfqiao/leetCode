package linkedlist;

public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		
	}
	
	 public ListNode deleteDuplicates(ListNode head) {
		 ListNode p = head;
		 ListNode q = null;
		 while (p != null) {
			 q = p.next;
			 if (q != null && p.val != q.val)
				 break;
			 while (q != null && p.val == q.val)
				 q = q.next;
			 p = q;
		 }
		 
		 return head;
		
	 }
}

class ListNode {
	int val;
	 ListNode next;
	 ListNode(int x) { 
		 val = x; 
	 }
}