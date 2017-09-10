package linkedlist;

/**
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln, r
 * eorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author hgf
 *
 */

public class ReorderList {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ReorderList rl = new ReorderList();
		rl.reorderList(l1);
		rl.print(l1);
	}
	
	public void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}
	
	
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode middle = getMiddle(head);
		ListNode end = reverse(middle);
		ListNode tmp = null;
		while (true) {
			//一个节点挪动后在选择移动另一个节点。Head移动完成后在移动end。
			tmp = head.next;
			head.next = end;
			head = tmp;
			if (head == null)
				break;
			tmp = end.next;
			end.next = head;
			end = tmp;
		}
	}
	
	//reverse一个链表，返回头结点
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		//if there is not only one node in the linked list.
		ListNode tmp = null;
		ListNode cur = head.next;
		head.next = null;
		while (cur != null) {
			tmp = cur.next;
			cur.next = head;
			head = cur;
			cur = tmp;
		}
		return head;
	}
	
	//将链表从中间断开,返回中间节点. （确定长度为奇数时中间节点放在前半段还是后半段）。
	//目前代码有问题，对于长度为2运行结果有问题。
	public ListNode getMiddle(ListNode node) {
		if (node == null)
			return null;
		ListNode fast = node;
		ListNode slow = node;
		ListNode slowParent = new ListNode(0);
		slowParent.next = slow;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slowParent = slow;
			slow = slow.next;
		}
		//后半段的节点个数与前半段相等（偶数个节点），或者比前半段多一个节点（奇数个节点）
		if (fast.next == null) {
			slowParent.next = null;
		}
		else {
			slowParent = slowParent.next;
			slow = slow.next;
			slowParent.next = null;
		}
		return slow;
	}
}
