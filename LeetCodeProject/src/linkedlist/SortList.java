package linkedlist;

/**
 * Sort a linked list in O(n log n) time using constant space complexity. Note:
 * 数字可能有正数，也有负数，
 * 
 * @author fangqiao.jfq
 *
 */
public class SortList {
	
	private ListNode sort(ListNode head) {
		ListNode[] nodesHead = new ListNode[10];
		ListNode[] nodesTail = new ListNode[10];
		ListNode headCopy = head;
		ListNode max = head;
		while (headCopy != null) {
			if (Math.abs(max.val) < Math.abs(headCopy.val))
				max = headCopy;
			headCopy = headCopy.next;
		}
		int times = 0;
		int maxValue = 0;
		if (max != null)
			maxValue = max.val;
		while (maxValue != 0) {
				maxValue /= 10;
				times++;
		}
		int radix = 10;
		while (times > 0) {
			headCopy = head;
			//按基数排序，利用链表收集。
			while (headCopy != null) { 
				int pos = (Math.abs(headCopy.val) % radix) / (radix / 10);
				if (nodesHead[pos] == null) {
					nodesHead[pos] = headCopy;
					nodesTail[pos] = headCopy;
				}
				else {
					nodesTail[pos].next = headCopy;
					nodesTail[pos] = headCopy;
				}
				//断开已经在排序链上的节点
				ListNode tmp = headCopy.next;
				headCopy.next = null;
				headCopy = tmp;
			}
			
			head = null;
			//收集每一趟排序的结果。
			for (int i = 0; i < 10; i++) {
				if (nodesHead[i] == null)
					continue;
				if (head == null) {
					head = nodesHead[i];
				}
				int j = i + 1;
				while (j < 9 && nodesHead[j] == null)
					j++;
				if (j > 9)
					break;
				nodesTail[i].next = nodesHead[j];
				nodesHead[i] = null;
				i = j - 1;
			}
			//要将最后一个nodesHead设置为null， 否则有问题。
			nodesHead[9] = null;
			if (head == null) {
				head = nodesHead[9];
				nodesHead[9] = null;
			}
//			printList(head);
			times--;
			radix *= 10;
		}
		return head;
	}
	
	private ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
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
	
	public ListNode sortList(ListNode head) {
		ListNode pos = new ListNode(0);
		ListNode neg = new ListNode(0);
		ListNode posHead = pos;
		ListNode negHead = neg;
		ListNode headCopy = head;
		while (headCopy != null) {
			if (headCopy.val >= 0) {
				pos.next = headCopy;
				pos = pos.next;
//				pos.next = null;
			}
			else {
				neg.next = headCopy;
				neg = neg.next;
//				neg.next = null;
			}
			ListNode tmp = headCopy.next;
			headCopy.next = null;
			headCopy = tmp;
		}
		negHead = sort(negHead.next);
		negHead = reverseList(negHead);
		posHead = sort(posHead.next);
		headCopy = negHead;
		if (headCopy == null)
			return posHead;
		while (headCopy.next != null) {
			headCopy = headCopy.next;
		}
		headCopy.next = posHead;
		return negHead;
	}
}
