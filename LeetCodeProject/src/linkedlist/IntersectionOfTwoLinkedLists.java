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
    public static void main(String[] args) {

    }

    /*
        idea:  将链表A的尾节点指向链表B的头节点，找新的链表是否有环即可。没有环则两个链表不相交，
        有环则表示两个链表相交，找到环开始的第一个节点就是相交的第一个节点。（问题转化了）。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        if (headA == null || headB == null) {
            return null;
        }
        ListNode lastA = headA;
        while (lastA != null && lastA.next != null) {
            lenA++;
            lastA = lastA.next;
        }
        lastA.next = headB;
        ListNode fast = headA, slow = headA;
        while (fast != null && fast.next != null) {
            if (fast == slow) {

            }
            fast = fast.next.next;
            if (fast == null) // if there is no ring in the new linked list
                return null;
            slow = slow.next;
        }

        return null;
    }
}
