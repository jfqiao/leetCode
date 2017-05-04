package linkedlist;

/**
 * Problem description:
 *   Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *   For example:
 *   Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *   return 1->4->3->2->5->NULL
 *   Note:
 *   Given m, n satisfy the following condition:1 ≤ m ≤ n ≤ length of list.
 * 
 * @author jfq
 *
 */

public class ReverseLinkedListII {
	public static void main(String[] args) {
		ReverseLinkedListII rllii = new ReverseLinkedListII();
		ListNode head = ListNode.generateListNode();
		ListNode.output(head);
		System.out.println();
		head = rllii.reverseBetween(head, 7, 7);
		ListNode.output(head);
	}
	
	/**
	 * 要求：只遍历一遍
	 * <br />此处所有输入满足 1 <= m <= n <= 链表长度
	 * @param head 链表的头结点
	 * @param m    需要翻转的开始位置
	 * @param n    需要翻转的结束位置
	 * @return     新链表的头结点
	 *
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		//为链表添加一个head，这样不用考虑开始节点的特殊情况了。
		ListNode addHead = new ListNode(0);
		addHead.next = head;
		// 结点m的前一个节点previous， 节点n的后一个节点last.
		ListNode previous;
		int count = 1;
		previous = addHead;
		while (count < m) {
			// 不用但是null, 因为参数m， n已经保证了
			previous = previous.next;
			count++;
		}
		
		ListNode p, q, r = null;
		p = previous;
		q = previous.next;
		ListNode reverseTail = q;
		count = m;
		while (count <= n) {
			if (q != null)
				r = q.next;
			q.next = p;
		    p = q;
		    q = r;
		    count++;
		}
		previous.next = p;
		reverseTail.next = q;
		return addHead.next;
	}
}
