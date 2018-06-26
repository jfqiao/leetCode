package linkedlist;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2 ↘
 *                      c1 → c2 → c3
 * B:     b1 → b2 → b3 ↗
 * begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @author jfqiao
 */

public class IntersectionOfTwoLinkedLists {

    /*
        idea:  将链表A的尾节点指向链表B的头节点，找新的链表是否有环即可。没有环则两个链表不相交，
        有环则表示两个链表相交，找到环开始的第一个节点就是相交的第一个节点。（问题转化了）。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
        		return null;
        int lenA = 0;
        int lenB = 0;
        ListNode tmp = headA;
        while (tmp != null) {
        		lenA++;
        		tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
        		lenB++;
        		tmp = tmp.next;
        }
        if (lenA > lenB) {
        		return getIntersectionNode(headA, headB, lenA - lenB, lenB);
        } else {
        		return getIntersectionNode(headB, headA, lenB - lenA, lenA);
        }
    }
    
    public ListNode getIntersectionNode(ListNode longHead, ListNode shortHead, int lenGap, int len) {
    		while (lenGap > 0) {
    			longHead = longHead.next;
    			lenGap--;
    		}
    		while (len > 0) {
    			if (longHead == shortHead)
    				return longHead;
    			len--;
    			longHead = longHead.next;
    			shortHead = shortHead.next;
    		}
    		return null;
    }
    
    public static void main(String[] args) {
    		ListNode node1 = new ListNode(3);
    		ListNode node2 = new ListNode(1);
    		ListNode node3 = new ListNode(5);
    		ListNode node4 = new ListNode(2);
    		ListNode node5 = new ListNode(4);
    		ListNode node6 = new ListNode(6);
    		ListNode node7 = new ListNode(4);
    		ListNode node8 = new ListNode(7);
    		node1.next = node2;
    		node2.next = node3;
    		node3.next = node4;
    		node4.next = node5;
    		node6.next = node7;
    		node7.next = node8;
    		node8.next = node3;
    		ListNode ins = new IntersectionOfTwoLinkedLists().getIntersectionNode(node1, node6);
    		System.out.println(ins);
    		System.out.println(node3);
    }
}
