package linkedlist;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author jfqiao
 *
 */
public class RemoveLinkedListElements {
	// AC
	public ListNode removeElements(ListNode head, int val) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode headStorage = preHead;
		while (preHead != null && preHead.next != null) {
			ListNode cur = preHead.next;
			if (cur.val ==  val) {
				preHead.next = cur.next;
				cur.next = null;  // 在实际中应该断掉，避免出现影响。
				continue;  // 不用继续移动到下一位。
			}
			preHead = preHead.next;
		}
		return headStorage.next;
	}
}
